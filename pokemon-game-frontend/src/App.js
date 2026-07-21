import React, { useState, useEffect } from 'react';
import './App.css';
import PokemonList from './components/PokemonList';
import Inventory from './components/Inventory';
import Battle from './components/Battle';
import StarterSelect from './components/StarterSelect';
import { clearGameState, loadGameState, saveGameState } from './utils/gameStorage';

function App() {
  const [trainerCollection, setTrainerCollection] = useState([]);
  const [inventory, setInventory] = useState([]);
  const [selectedPokemon, setSelectedPokemon] = useState(null);
  const [battle, setBattle] = useState(null);
  const [loading, setLoading] = useState(true);
  const [inventoryLoading, setInventoryLoading] = useState(true);
  const [error, setError] = useState(null);
  const [showInventory, setShowInventory] = useState(false);
  const [saveMessage, setSaveMessage] = useState('');

  const fetchTrainerCollection = async () => {
    try {
      const response = await fetch('/api/trainer/collection');
      if (!response.ok) throw new Error('Failed to fetch trainer collection');
      const data = await response.json();
      setTrainerCollection(data);
      setLoading(false);
    } catch (err) {
      setError(err.message);
      setLoading(false);
    }
  };

  const fetchInventory = async () => {
    try {
      const response = await fetch('/api/inventory');
      if (!response.ok) throw new Error('Failed to fetch inventory');
      const data = await response.json();
      setInventory(data);
      setInventoryLoading(false);
    } catch (err) {
      console.error('Error fetching inventory:', err);
      setInventoryLoading(false);
    }
  };

  useEffect(() => {
    const savedState = loadGameState();

    if (savedState) {
      setTrainerCollection(savedState.trainerCollection || []);
      setInventory(savedState.inventory || []);
      setSelectedPokemon(savedState.selectedPokemon || null);
      setBattle(savedState.battle || null);
      setShowInventory(Boolean(savedState.showInventory));
      setInventoryLoading(false);
      setLoading(false);
      setSaveMessage('Loaded saved game');
      return;
    }

    fetchTrainerCollection();
    fetchInventory();
  }, []);

  useEffect(() => {
    if (loading) return;

    saveGameState({
      trainerCollection,
      inventory,
      selectedPokemon,
      battle,
      showInventory
    });
  }, [battle, inventory, loading, selectedPokemon, showInventory, trainerCollection]);

  const handleSaveGame = () => {
    const saved = saveGameState({
      trainerCollection,
      inventory,
      selectedPokemon,
      battle,
      showInventory
    });

    setSaveMessage(saved ? 'Game saved!' : 'Could not save game');
  };

  const handleLoadGame = () => {
    const savedState = loadGameState();

    if (!savedState) {
      setSaveMessage('No saved game found');
      return;
    }

    setTrainerCollection(savedState.trainerCollection || []);
    setInventory(savedState.inventory || []);
    setSelectedPokemon(savedState.selectedPokemon || null);
    setBattle(savedState.battle || null);
    setShowInventory(Boolean(savedState.showInventory));
    setLoading(false);
    setInventoryLoading(false);
    setSaveMessage('Saved game loaded');
  };

  const handleClearSave = () => {
    const cleared = clearGameState();
    setSaveMessage(cleared ? 'Saved game cleared' : 'Could not clear saved game');
  };

  const startBattle = async (playerPokemonId) => {
    try {
      const response = await fetch('/api/battle/start', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ playerPokemonId })
      });

      if (!response.ok) throw new Error('Failed to start battle');
      const battleData = await response.json();
      setBattle(battleData);
    } catch (err) {
      setError(err.message);
    }
  };

  const handlePokemonSelect = (pokemon) => {
    setSelectedPokemon(pokemon);
    startBattle(pokemon.id);
  };

  const handleBackToMenu = () => {
    if (battle && battle.caught) {
      fetchTrainerCollection();
      fetchInventory();
    }

    setBattle(null);
    setSelectedPokemon(null);
  };

  const handleNewGame = async () => {
    try {
      const [trainerResponse, inventoryResponse] = await Promise.all([
        fetch('/api/trainer/reset', { method: 'POST' }),
        fetch('/api/inventory/reset', { method: 'POST' })
      ]);

      if (!trainerResponse.ok || !inventoryResponse.ok) {
        throw new Error('Failed to reset game');
      }

      clearGameState();

      setTrainerCollection([]);
      setInventory([]);
      setSelectedPokemon(null);
      setBattle(null);
      setShowInventory(false);
      setLoading(false);
      setInventoryLoading(false);
      setError(null);
      setSaveMessage('New game started');
    } catch (err) {
      setError(err.message);
      setSaveMessage('Could not start a new game');
    }
  };

  const handleStarterChosen = () => {
    fetchTrainerCollection();
  };

  if (loading) {
    return <div className="loading">Loading...</div>;
  }

  if (error) {
    return <div className="error">Error: {error}</div>;
  }

  return (
      <div className="App">
        <header className="App-header">
          <h1>🎮 Pokemon Battle Game</h1>

          <div className="game-actions">
            <button className="game-action-button" onClick={handleNewGame}>
              New Game
            </button>
            <button className="game-action-button" onClick={handleSaveGame}>
              Save Game
            </button>
            <button className="game-action-button" onClick={handleLoadGame}>
              Load Game
            </button>
            <button className="game-action-button secondary" onClick={handleClearSave}>
              Clear Save
            </button>
          </div>

          {saveMessage && <p className="save-message">{saveMessage}</p>}
        </header>

        <main className="App-main">
          {!battle ? (
              trainerCollection.length === 0 ? (
                  <StarterSelect onStarterChosen={handleStarterChosen} />
              ) : (
                  <div className="menu-layout">
                    <button className="Inventory-button" onClick={() => setShowInventory(true)}>
                      Inventory
                    </button>

                    {showInventory && (
                        <Inventory
                            entries={inventory}
                            loading={inventoryLoading}
                            onClose={() => setShowInventory(false)}
                        />
                    )}

                    <PokemonList
                        pokemon={trainerCollection}
                        onSelectPokemon={handlePokemonSelect}
                    />
                  </div>
              )
          ) : (
              <Battle
                  battle={battle}
                  setBattle={setBattle}
                  onBackToMenu={handleBackToMenu}
                  onInventoryChanged={fetchInventory}
                  inventoryEntries={inventory}
              />
          )}
        </main>
      </div>
  );
}

export default App;