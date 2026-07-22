// ============================================================================
// index.js — THE ENTRY POINT of the React app.
//
// When the browser loads the page, this is the very first JS file that runs.
// Its only job is to take our top-level React component (<App />) and "mount"
// it into the HTML page. Everything you see on screen is rendered from here.
// ============================================================================

// React is the core library (lets us define components and use JSX).
import React from 'react';
// ReactDOM is the "glue" between React and the browser's actual DOM (the HTML
// page). 'react-dom/client' is the React 18+ entry point for rendering.
import ReactDOM from 'react-dom/client';
// Importing a CSS file in JS looks odd, but the build tool (react-scripts /
// webpack) sees this and injects the stylesheet into the page for us.
import './index.css';
// Our top-level component. The './App' path (no extension) resolves to App.js.
import App from './App';

// Find the <div id="root"></div> element in public/index.html — that empty div
// is the container React will fill with our whole UI. createRoot() prepares it.
const root = ReactDOM.createRoot(document.getElementById('root'));

// Render our component tree into that root. From this point on, React owns the
// contents of #root and updates it whenever our components' data changes.
root.render(
  // <React.StrictMode> is a development-only helper. It doesn't render anything
  // visible; it just runs extra checks and warns about unsafe patterns. (One
  // side effect: in dev it intentionally runs some code twice to help you spot
  // bugs — harmless, and it doesn't happen in the production build.)
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
