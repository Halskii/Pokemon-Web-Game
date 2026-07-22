import React from 'react';
import './shop.css';

function shop({ onClose }) {

    const items = [
        { id: 1, name: 'Potion', icon: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/potion.png', price: 50 },
        { id: 2, name: 'Poké Ball', icon: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/poke-ball.png', price: 100 },
        { id: 3, name: 'Super Potion', icon: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/super-potion.png', price: 150 },
        { id: 4, name: 'Great Ball', icon: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/great-ball.png', price: 200 },
        { id: 5, name: 'Ultra Ball', icon: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/ultra-ball.png', price: 300 },
        
    ];

    return (
        <div className="shop">
            <h2>shop</h2>
            <div className="shop-items">
                {items.map((item) => (
                    <div key={item.id} className="shop-item">
                        <div className="item-icon">{item.icon}</div>
                        <div className="item-name">{item.name}</div>
                        <div className="item-price">×{item.price}</div>
                    </div>
                ))}
            </div>
            <button onClick={onClose}>Close</button>
        </div>
    );
}
export default shop;
