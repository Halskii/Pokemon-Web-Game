import React from 'react';
import './PokemonList.css';

function PokemonList({ pokemon, onSelectPokemon }) {
  const getTypeColor = (type) => {
    const colors = {
      Fire: '#F08030',
      Water: '#6890F0',
      Grass: '#78C850',
      Electric: '#F8D030',
      Rock: '#B8A038',
      Flying: '#A890F0',
      Normal: '#A8A878'
    };
    return colors[type] || '#A8A878';
  };

  return (
    <div className="pokemon-list">
      <h2>Choose Your Pokemon</h2>
      <div className="pokemon-grid">
        {pokemon.map((poke) => (
          <div 
            key={poke.id} 
            className="pokemon-card"
            onClick={() => onSelectPokemon(poke)}
          >
            <div className="pokemon-image">
              <img src={poke.sprite} alt={poke.name} />
            </div>
            <h3>{poke.name}</h3>
            <span 
              className="pokemon-type" 
              style={{ backgroundColor: getTypeColor(poke.type) }}
            >
              {poke.type}
            </span>
            <div className="pokemon-stats">
              <div className="stat">
                <span>HP:</span> <strong>{poke.maxHp}</strong>
              </div>
              <div className="stat">
                <span>ATK:</span> <strong>{poke.attack}</strong>
              </div>
              <div className="stat">
                <span>DEF:</span> <strong>{poke.defense}</strong>
              </div>
              <div className="stat">
                <span>SPD:</span> <strong>{poke.speed}</strong>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default PokemonList;
