import React from 'react';
import './Inventory.css';

function Inventory({ onClose }) {

    const items = [
        { id: 1, name: 'Potion', icon: '🧪', quantity: 3 },
        { id: 2, name: 'Poké Ball', icon: '⚪', quantity: 5 },
        // add a couple more
    ];

  return (
    <div className="inventory">
      <h2>Inventory</h2>
        <div className="inventory-items">
            {items.map((item) => (
                <div key={item.id} className="inventory-item">
                    <div className="item-icon">{item.icon}</div>
                    <div className="item-name">{item.name}</div>
                    <div className="item-qty">×{item.quantity}</div>
                </div>
            ))}
        </div>
      <button onClick={onClose}>Close</button>
    </div>
  );
}
export default Inventory;
