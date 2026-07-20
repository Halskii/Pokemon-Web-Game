// ============================================================================
// Battle.js — the battle screen where the actual fighting happens.
//
// Unlike PokemonList, this component has a little local state of its own (to
// drive animations) AND makes a backend call each time the player picks a move.
// The authoritative battle data still lives in App; we update it via setBattle.
// ============================================================================

import React, { useState } from 'react';
import './Battle.css';

// Props: `battle` (the current battle data from App), `setBattle` (App's state
// setter, so we can push updates back up), and `onBackToMenu` (a callback).
function Battle({ battle, setBattle, onBackToMenu }) {
  // LOCAL state — only this component cares about it, so it lives here rather
  // than in App. These exist purely to drive the attack animation/UX.
  const [selectedMove, setSelectedMove] = useState(null); // which move is mid-animation
  const [isAttacking, setIsAttacking] = useState(false);  // true while a move resolves

  // --- BACKEND CALL: play a move ----------------------------------------
  const executeMove = async (moveName) => {
    // Guard: if an attack is already in progress, ignore extra clicks. This
    // prevents the player from firing off multiple moves at once.
    if (isAttacking) return;
    setIsAttacking(true);      // lock input + trigger the "shake" CSS class
    setSelectedMove(moveName); // remember which button to highlight/animate

    try {
      // A template literal (backticks) lets us drop the battle id into the URL.
      // This maps to BattleController's @PostMapping("/{battleId}/move"), where
      // {battleId} is a @PathVariable. So `battle.id` fills that slot.
      const response = await fetch(`/api/battle/${battle.id}/move`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        // The body's "moveName" key matches request.get("moveName") in Java.
        body: JSON.stringify({ moveName })
      });

      if (!response.ok) throw new Error('Failed to execute move');
      // The backend runs the whole turn (player attack + opponent counter),
      // then returns the UPDATED battle (new HP values, a longer log, etc.).
      const updatedBattle = await response.json();

      // Add delay for animation
      // setTimeout waits 1000ms before applying the result, so the attack
      // animation has time to play before the health bars visibly change.
      setTimeout(() => {
        setBattle(updatedBattle); // push new data up to App -> whole UI updates
        setSelectedMove(null);    // clear animation state
        setIsAttacking(false);    // unlock the move buttons again
      }, 1000);
    } catch (err) {
      // On failure, log it and unlock input so the player isn't stuck.
      console.error('Error executing move:', err);
      setIsAttacking(false);
    }
  };

  // --- Small display helpers (plain JS, no React involved) --------------
  // Convert current/max HP into a 0-100 percentage for the health-bar width.
  const getHealthPercentage = (current, max) => {
    return (current / max) * 100;
  };

  // Pick a bar color based on how much health is left: green -> orange -> red.
  const getHealthBarColor = (percentage) => {
    if (percentage > 50) return '#4caf50';
    if (percentage > 20) return '#ff9800';
    return '#f44336';
  };

  // Derived values — computed fresh on every render from current state/props.
  // We don't store these in state; they're just read from the latest battle
  // data, which keeps them from ever getting out of sync.
  const isBattleOver = battle.player.currentHp <= 0 || battle.opponent.currentHp <= 0;
  const playerWon = battle.opponent.currentHp <= 0 && battle.player.currentHp > 0;

  return (
    <div className="battle-container">
      <button className="back-button" onClick={onBackToMenu}>
        ← Back to Menu
      </button>

      <div className="battle-field">
        {/* Opponent Pokemon */}
        <div className="pokemon-slot opponent-slot">
          <div className="pokemon-info">
            <h3>{battle.opponent.name}</h3>
            <div className="health-bar-container">
              {/* The bar's width and color are computed inline from HP. Because
                  these are recalculated every render, the bar animates smoothly
                  as `battle` updates after each move. */}
              <div
                className="health-bar"
                style={{
                  width: `${getHealthPercentage(battle.opponent.currentHp, battle.opponent.maxHp)}%`,
                  backgroundColor: getHealthBarColor(getHealthPercentage(battle.opponent.currentHp, battle.opponent.maxHp))
                }}
              ></div>
            </div>
            <div className="hp-text">
              HP: {battle.opponent.currentHp} / {battle.opponent.maxHp}
            </div>
          </div>
          {/* Conditionally add the "shake" class only while attacking. This is
              a common trick: build a className string from state to toggle a
              CSS animation on and off. */}
          <div className={`pokemon-sprite ${isAttacking ? 'shake' : ''}`}>
            <img src={battle.opponent.sprite} alt={battle.opponent.name} />
          </div>
        </div>

        {/* Player Pokemon */}
        <div className="pokemon-slot player-slot">
          {/* Same className trick: add "attack" while a move is selected. */}
          <div className={`pokemon-sprite ${selectedMove ? 'attack' : ''}`}>
            <img src={battle.player.sprite} alt={battle.player.name} />
          </div>
          <div className="pokemon-info">
            <h3>{battle.player.name}</h3>
            <div className="health-bar-container">
              <div
                className="health-bar"
                style={{
                  width: `${getHealthPercentage(battle.player.currentHp, battle.player.maxHp)}%`,
                  backgroundColor: getHealthBarColor(getHealthPercentage(battle.player.currentHp, battle.player.maxHp))
                }}
              ></div>
            </div>
            <div className="hp-text">
              HP: {battle.player.currentHp} / {battle.player.maxHp}
            </div>
          </div>
        </div>
      </div>

      {/* Battle Controls */}
      <div className="battle-controls">
        {/* If the battle is over, show the result + a return button; otherwise
            show the move buttons. Another conditional render via ternary. */}
        {isBattleOver ? (
          <div className="battle-result">
            <h2>{playerWon ? '🎉 You Won!' : '😢 You Lost!'}</h2>
            <button className="menu-button" onClick={onBackToMenu}>
              Return to Menu
            </button>
          </div>
        ) : (
          <div className="moves-grid">
            <h3>Choose a Move:</h3>
            <div className="moves">
              {/* One button per move in the player's move list (again via .map).
                  The move data originates from the Java Move model. */}
              {battle.player.moves.map((move) => (
                <button
                  key={move.name}
                  // Highlight this button if it's the one currently selected.
                  className={`move-button ${selectedMove === move.name ? 'selected' : ''}`}
                  // Clicking fires the backend call for this move.
                  onClick={() => executeMove(move.name)}
                  // The `disabled` prop greys out and blocks the button while an
                  // attack is resolving — the UI-level partner to the isAttacking
                  // guard at the top of executeMove.
                  disabled={isAttacking}
                >
                  <div className="move-name">{move.name}</div>
                  <div className="move-details">
                    <span className="move-type">{move.type}</span>
                    <span className="move-power">PWR: {move.power}</span>
                  </div>
                </button>
              ))}
            </div>
          </div>
        )}
      </div>

      {/* Battle Log */}
      <div className="battle-log">
        <h4>Battle Log:</h4>
        <div className="log-entries">
          {/* battle.log is an array of message strings from the backend.
              .slice(-5) keeps only the last 5 entries so the log stays short. */}
          {battle.log.slice(-5).map((entry, index) => (
            // These log lines have no unique id, so we fall back to the array
            // index as the key. That's acceptable here because the list is
            // append-only display text — but for reorderable data, prefer a
            // real stable id (as we do everywhere else).
            <div key={index} className="log-entry">
              {entry}
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default Battle;
