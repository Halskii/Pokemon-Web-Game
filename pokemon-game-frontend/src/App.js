// ============================================================================
// App.js — THE ROOT COMPONENT and the "brain" of the frontend.
//
// This component does three big things:
//   1. Holds the app's main STATE (the trainer's collection, the current battle, etc.).
//   2. TALKS TO THE BACKEND over HTTP (this is the frontend<->backend bridge).
//   3. Decides which child component to show: starter picker, Pokemon picker, or battle.
// ============================================================================

import React, { useState, useEffect } from 'react';
import './App.css';
import PokemonList from './components/PokemonList';
import Inventory from './components/Inventory';
import Battle from './components/Battle';
import StarterSelect from './components/StarterSelect';

function App() {
  // The trainer's caught Pokemon (starts empty until a starter is chosen).
  // This is what "Choose your Pokemon" now picks from, instead of the full Pokedex.
  const [trainerCollection, setTrainerCollection] = useState([]);
  const [selectedPokemon, setSelectedPokemon] = useState(null);
  const [battle, setBattle] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [showInventory, setShowInventory] = useState(false);

  useEffect(() => {
    fetchTrainerCollection();
  }, []);

  // Maps to TrainerController's @GetMapping on "/api/trainer/collection".
  // An empty array means the player hasn't picked a starter yet.
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

  // The backend now picks a random wild opponent itself, so we only send
  // which of the trainer's own Pokemon is fighting.
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

  // Called by PokemonList when the user clicks a Pokemon card.
  const handlePokemonSelect = (pokemon) => {
    setSelectedPokemon(pokemon);
    startBattle(pokemon.id);
  };

  // Called by Battle's "Back to Menu" button.
  const handleBackToMenu = () => {
    // Catching a wild Pokemon adds it to the collection on the backend; refresh
    // here so the newly caught Pokemon shows up in the picker right away.
    if (battle && battle.caught) {
      fetchTrainerCollection();
    }
    setBattle(null);
    setSelectedPokemon(null);
  };

  // Called by StarterSelect once the player has picked Bulbasaur/Charmander/Squirtle.
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
      </header>

      <main className="App-main">
        {!battle ? (
          trainerCollection.length === 0 ? (
            // No starter yet — show the starter picker instead of the menu.
            <StarterSelect onStarterChosen={handleStarterChosen} />
          ) : (
            <div className="menu-layout">
              <button className={"Inventory-button"} onClick={() => setShowInventory(true)}>
                Inventory
              </button>
              {showInventory && <Inventory onClose={() => setShowInventory(false)} />}
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
          />
        )}
      </main>
    </div>
  );
}

export default App;
