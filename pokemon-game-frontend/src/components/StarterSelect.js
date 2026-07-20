import React, { useState, useEffect } from 'react';
import './PokemonList.css';

// The three classic starters, by their Pokedex id (must match TrainerService.STARTER_IDS on the backend).
const STARTER_IDS = [1, 4, 7]; // Bulbasaur, Charmander, Squirtle

function StarterSelect({ onStarterChosen }) {
  const [starters, setStarters] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchStarters = async () => {
      const responses = await Promise.all(
        STARTER_IDS.map((id) => fetch(`/api/pokemon/${id}`))
      );
      const data = await Promise.all(responses.map((r) => r.json()));
      setStarters(data);
      setLoading(false);
    };
    fetchStarters();
  }, []);

  const chooseStarter = async (pokemonId) => {
    const response = await fetch(`/api/trainer/starter/${pokemonId}`, {
      method: 'POST'
    });
    if (response.ok) {
      onStarterChosen();
    }
  };

  if (loading) {
    return <div className="loading">Loading starters...</div>;
  }

  return (
    <div className="pokemon-list">
      <h2>Pick Your Starter</h2>
      <div className="pokemon-grid">
        {starters.map((poke) => (
          <div
            key={poke.id}
            className="pokemon-card"
            onClick={() => chooseStarter(poke.id)}
          >
            <div className="pokemon-image">
              <img src={poke.sprite} alt={poke.name} />
            </div>
            <h3>{poke.name}</h3>
          </div>
        ))}
      </div>
    </div>
  );
}

export default StarterSelect;
