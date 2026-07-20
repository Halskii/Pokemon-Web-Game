import React, { useState, useEffect } from 'react';
import './Inventory.css';

// `onSelectItem` is optional: when provided (e.g. from Battle), each row becomes
// clickable and picking one calls it. Without it, this is just a read-only panel.
function Inventory({ onClose, onSelectItem }) {
  const [entries, setEntries] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchInventory = async () => {
      try {
        // Maps to InventoryController's @GetMapping on "/api/inventory".
        // Each entry is { item: {id, name, icon, price, itemType, potency}, quantity }.
        const response = await fetch('/api/inventory');
        if (!response.ok) throw new Error('Failed to fetch inventory');
        const data = await response.json();
        setEntries(data);
      } catch (err) {
        console.error('Error fetching inventory:', err);
      } finally {
        setLoading(false);
      }
    };
    fetchInventory();
  }, []);

  return (
    <div className="inventory">
      <h2>Inventory</h2>
      {loading ? (
        <p>Loading...</p>
      ) : entries.length === 0 ? (
        <p>No items yet.</p>
      ) : (
        <div className="inventory-items">
          {entries.map((entry) => (
            <div
              key={entry.item.id}
              className={`inventory-item ${onSelectItem ? 'selectable' : ''}`}
              onClick={onSelectItem ? () => onSelectItem(entry.item) : undefined}
            >
              <div className="item-icon">
                <img src={entry.item.icon} alt={entry.item.name} />
              </div>
              <div className="item-name">{entry.item.name}</div>
              <div className="item-qty">×{entry.quantity}</div>
            </div>
          ))}
        </div>
      )}
      <button onClick={onClose}>Close</button>
    </div>
  );
}

export default Inventory;
