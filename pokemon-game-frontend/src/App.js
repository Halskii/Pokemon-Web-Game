import React, { useState, useEffect } from 'react';
import './App.css';
import PokemonList from './components/PokemonList';
import Battle from './components/Battle';

function App() {
  const [pokemon, setPokemon] = useState([]);
  const [selectedPokemon, setSelectedPokemon] = useState(null);
  const [battle, setBattle] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchPokemon();
  }, []);

  const fetchPokemon = async () => {
    try {
      const response = await fetch('/api/pokemon');
      if (!response.ok) throw new Error('Failed to fetch Pokemon');
      const data = await response.json();
      setPokemon(data);
      setLoading(false);
    } catch (err) {
      setError(err.message);
      setLoading(false);
    }
  };

  const startBattle = async (playerPokemonId) => {
    try {
      // Randomly select an opponent
      const availableOpponents = pokemon.filter(p => p.id !== playerPokemonId);
      const opponent = availableOpponents[Math.floor(Math.random() * availableOpponents.length)];
      
      const response = await fetch('/api/battle/start', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          playerPokemonId,
          opponentPokemonId: opponent.id
        })
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
    setBattle(null);
    setSelectedPokemon(null);
  };

  if (loading) {
    return <div className="loading">Loading Pokemon...</div>;
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
          <PokemonList 
            pokemon={pokemon} 
            onSelectPokemon={handlePokemonSelect}
          />
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
