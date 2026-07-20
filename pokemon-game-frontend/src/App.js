// ============================================================================
// App.js — THE ROOT COMPONENT and the "brain" of the frontend.
//
// This component does three big things:
//   1. Holds the app's main STATE (the Pokemon list, the current battle, etc.).
//   2. TALKS TO THE BACKEND over HTTP (this is the frontend<->backend bridge).
//   3. Decides which child component to show: the Pokemon picker or the battle.
// ============================================================================

// useState and useEffect are React "hooks" — special functions that let a
// component remember data between renders (useState) and run side effects like
// data fetching (useEffect). We import them alongside React itself.
import React, { useState, useEffect } from 'react';
import './App.css';
// Child components live in ./components. We render these inside App below.
import PokemonList from './components/PokemonList';
import Inventory from './components/Inventory';
import Battle from './components/Battle';

// A React component is just a function that returns JSX (HTML-like markup).
// The function re-runs ("re-renders") every time its state or props change.
function App() {
  // --- STATE ------------------------------------------------------------
  // useState(initialValue) returns a pair: [currentValue, setterFunction].
  // Calling the setter with a new value tells React "this data changed —
  // re-render the component so the screen reflects it." You must NEVER assign
  // to these variables directly; always go through the setter.

  // The full list of Pokemon fetched from the backend. Starts as an empty array.
  const [pokemon, setPokemon] = useState([]);
  // The Pokemon the user clicked (currently just tracked; battle uses its id).
  const [selectedPokemon, setSelectedPokemon] = useState(null);
  // The active battle object returned by the backend. null = no battle yet.
  const [battle, setBattle] = useState(null);
  // Whether we're still waiting on the initial data load (shows a spinner text).
  const [loading, setLoading] = useState(true);
  // Holds an error message string if a request fails; null when all is well.
  const [error, setError] = useState(null);
    // Whether the inventory modal is open. (Not implemented yet.)
    const [showInventory, setShowInventory] = useState(false);

  // --- SIDE EFFECT: load data once on startup ---------------------------
  // useEffect runs code *after* the component renders. The second argument is
  // the "dependency array": [] means "run this exactly once, when the component
  // first mounts" — perfect for fetching initial data. (If we put values in the
  // array, the effect would re-run whenever those values changed.)
  useEffect(() => {
    fetchPokemon();
  }, []);

  // --- BACKEND CALL #1: get the list of Pokemon -------------------------
  // 'async' lets us use 'await' to pause until the network request finishes,
  // written in a clean top-to-bottom style instead of nested callbacks.
  const fetchPokemon = async () => {
    try {
      // fetch() is the browser's built-in HTTP client. The URL is relative
      // ('/api/pokemon', no host). In development, package.json has
      //   "proxy": "http://localhost:8080"
      // which tells the dev server to forward '/api/*' calls to the Spring Boot
      // backend on port 8080. That's how the React app (port 3000) reaches Java
      // without hard-coding the backend address or hitting CORS problems.
      // This maps to PokemonController's @GetMapping on "/api/pokemon".
      const response = await fetch('/api/pokemon');
      // fetch does NOT throw on HTTP error codes (404/500); it only rejects on
      // network failure. So we check response.ok ourselves and throw if not.
      if (!response.ok) throw new Error('Failed to fetch Pokemon');
      // .json() reads the response body and parses the JSON text into JS
      // objects. The backend returns a List<Pokemon>, which arrives here as an
      // array of plain objects (fields like id, name, type, maxHp, sprite...).
      const data = await response.json();
      setPokemon(data);     // store it in state -> triggers a re-render
      setLoading(false);    // we're done loading, so hide the "Loading..." text
    } catch (err) {
      // Any thrown error (network down, bad response) lands here.
      setError(err.message);
      setLoading(false);
    }
  };

  // --- BACKEND CALL #2: start a battle ----------------------------------
  const startBattle = async (playerPokemonId) => {
    try {
      // Pick a random opponent from the list, excluding the player's choice.
      const availableOpponents = pokemon.filter(p => p.id !== playerPokemonId);
      const opponent = availableOpponents[Math.floor(Math.random() * availableOpponents.length)];

      // A POST request sends data TO the server (vs. GET which just reads).
      // This maps to BattleController's @PostMapping("/start").
      const response = await fetch('/api/battle/start', {
        method: 'POST',
        // Headers describe the request. We tell the server the body is JSON so
        // Spring knows to parse it into the Java @RequestBody Map.
        headers: { 'Content-Type': 'application/json' },
        // The body must be a STRING, so we serialize our JS object with
        // JSON.stringify. The two keys here match exactly what the Java
        // controller reads: request.get("playerPokemonId") / "opponentPokemonId".
        body: JSON.stringify({
          playerPokemonId,
          opponentPokemonId: opponent.id
        })
      });

      if (!response.ok) throw new Error('Failed to start battle');
      // The backend responds with the newly created Battle object (with an id,
      // both Pokemon's stats, a move list, and a log). We save it in state...
      const battleData = await response.json();
      setBattle(battleData); // ...which flips the UI from the list to the Battle view.
    } catch (err) {
      setError(err.message);
    }
  };

  // --- EVENT HANDLERS ---------------------------------------------------
  // These are passed DOWN to child components as props (see the JSX below).
  // The child calls them when the user interacts, and the logic runs up here
  // where the state lives. This "data down, events up" flow is core to React.

  // Called by PokemonList when the user clicks a Pokemon card.
  const handlePokemonSelect = (pokemon) => {
    setSelectedPokemon(pokemon);
    startBattle(pokemon.id);
  };

  // Called by Battle's "Back to Menu" button. Clearing battle -> shows the list.
  const handleBackToMenu = () => {
    setBattle(null);
    setSelectedPokemon(null);
  };

  // --- RENDER -----------------------------------------------------------
  // A component can "return early" to show different UIs. These guard clauses
  // handle the loading and error states before the main screen.
  if (loading) {
    return <div className="loading">Loading Pokemon...</div>;
  }

  if (error) {
    // {error} is JSX interpolation: anything in {curly braces} is evaluated as
    // JavaScript and inserted into the markup. Here it prints the error string.
    return <div className="error">Error: {error}</div>;
  }

  // The normal UI. JSX looks like HTML but is really JavaScript; note we use
  // className instead of class, and can embed logic with {}.
  return (
    <div className="App">
      <header className="App-header">
        <h1>🎮 Pokemon Battle Game</h1>
      </header>



      {/* This is the main section where either the Pokemon list or the battle component
      will be displayed based on the state of the battle. */}
      <main className="App-main">
        {/* This is a "ternary" (condition ? A : B) used for conditional
            rendering. If there's no battle, show the picker; otherwise show the
            battle. React re-runs this whenever `battle` state changes, so
            calling setBattle() automatically swaps the screen. */}
        {!battle ? (
          // PROPS: we pass data (pokemon) and a callback (onSelectPokemon) down
          // into the child. The child receives these as its function arguments.
            <div className="menu-layout">
              {/* inventory FIRST = on the left; && still controls showing it */}
              <button className={"Inventory-button"} onClick={() => setShowInventory(true)}>
                Inventory
              </button>
              {showInventory && <Inventory onClose={() => setShowInventory(false)} />}
              <PokemonList
                  pokemon={pokemon}
                  onSelectPokemon={handlePokemonSelect}
              />
            </div>
        ) : (
          // We also hand Battle the setter itself (setBattle) so it can update
          // the shared battle state directly after each move.
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

// Make this component importable elsewhere (index.js imports it as <App />).
export default App;
