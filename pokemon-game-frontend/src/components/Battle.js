import React, { useState } from 'react';
import './Battle.css';

function Battle({ battle, setBattle, onBackToMenu }) {
  const [selectedMove, setSelectedMove] = useState(null);
  const [isAttacking, setIsAttacking] = useState(false);

  const executeMove = async (moveName) => {
    if (isAttacking) return;
    setIsAttacking(true);
    setSelectedMove(moveName);

    try {
      const response = await fetch(`/api/battle/${battle.id}/move`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ moveName })
      });

      if (!response.ok) throw new Error('Failed to execute move');
      const updatedBattle = await response.json();
      
      // Add delay for animation
      setTimeout(() => {
        setBattle(updatedBattle);
        setSelectedMove(null);
        setIsAttacking(false);
      }, 1000);
    } catch (err) {
      console.error('Error executing move:', err);
      setIsAttacking(false);
    }
  };

  const getHealthPercentage = (current, max) => {
    return (current / max) * 100;
  };

  const getHealthBarColor = (percentage) => {
    if (percentage > 50) return '#4caf50';
    if (percentage > 20) return '#ff9800';
    return '#f44336';
  };

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
          <div className={`pokemon-sprite ${isAttacking ? 'shake' : ''}`}>
            <img src={battle.opponent.sprite} alt={battle.opponent.name} />
          </div>
        </div>

        {/* Player Pokemon */}
        <div className="pokemon-slot player-slot">
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
              {battle.player.moves.map((move) => (
                <button
                  key={move.name}
                  className={`move-button ${selectedMove === move.name ? 'selected' : ''}`}
                  onClick={() => executeMove(move.name)}
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
          {battle.log.slice(-5).map((entry, index) => (
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
