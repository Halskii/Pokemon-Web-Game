// ============================================================================
// PokemonList.js — the "choose your Pokemon" screen.
//
// This is a good example of a PRESENTATIONAL component: it holds no state and
// makes no network calls. It just receives data via props and draws it, and
// reports clicks back up to the parent (App). Simple, predictable, reusable.
// ============================================================================

import React from 'react';
import './PokemonList.css';

// PROPS come in as a single object; here we use destructuring to pull out the
// two fields we expect: `pokemon` (the array to display) and `onSelectPokemon`
// (a callback App gave us to run when a card is clicked).
function PokemonList({ pokemon, onSelectPokemon }) {
  // A plain helper function — not a hook, just normal JS. Given a type name,
  // it returns the matching brand color so each card is themed by type.
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
    // If the type isn't in our map, fall back to the Normal-type gray.
    // (colors[type] is `undefined` for unknown keys, and `undefined || x` -> x.)
    return colors[type] || '#A8A878';
  };

  return (
    <div className="pokemon-list">
      <h2>Choose Your Pokemon</h2>
      <div className="pokemon-grid">
        {/* .map() turns each Pokemon object into a piece of JSX. This is the
            standard React way to render a list: transform an array of data
            into an array of elements, which React renders in order. */}
        {pokemon.map((poke) => (
          <div
            // `key` is REQUIRED (and must be unique) when rendering lists. React
            // uses it to track which item is which across re-renders so it can
            // update efficiently. Using a stable id (not the array index) is best.
            key={poke.id}
            className="pokemon-card"
            // onClick wires a browser click to our handler. We wrap it in an
            // arrow function so it isn't called immediately during render —
            // it only fires when the user actually clicks. When it does, we
            // call the parent's callback and pass this Pokemon back up to App.
            onClick={() => onSelectPokemon(poke)}
          >
            <div className="pokemon-image">
              {/* Field names (sprite, name, ...) match the Java Pokemon model,
                  because this data came straight from the backend as JSON. */}
              <img src={poke.sprite} alt={poke.name} />
            </div>
            <h3>{poke.name}</h3>
            <h4>Level: {poke.level}</h4>
            <span
              className="pokemon-type"
              // The `style` prop takes a JS object (note the double braces:
              // the outer {} enters JS, the inner {} is the object literal).
              // CSS property names are camelCased: backgroundColor, not
              // background-color. Here the color is computed per Pokemon type.
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
