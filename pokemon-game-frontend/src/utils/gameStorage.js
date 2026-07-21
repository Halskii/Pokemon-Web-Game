const STORAGE_KEY = 'pokemon-game-save';

export function saveGameState(gameState) {
    try {
        const payload = {
            version: 1,
            savedAt: new Date().toISOString(),
            ...gameState
        };

        window.localStorage.setItem(STORAGE_KEY, JSON.stringify(payload));
        return true;
    } catch (err) {
        console.error('Failed to save game', err);
        return false;
    }
}

export function loadGameState() {
    try {
        const raw = window.localStorage.getItem(STORAGE_KEY);
        if (!raw) return null;
        return JSON.parse(raw);
    } catch (err) {
        console.error('Failed to load game', err);
        return null;
    }
}

export function clearGameState() {
    try {
        window.localStorage.removeItem(STORAGE_KEY);
        return true;
    } catch (err) {
        console.error('Failed to clear game', err);
        return false;
    }
}