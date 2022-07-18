import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App, { App as App2 } from './App';
import { Provider } from 'react-redux';
import { store } from './store';

// Gets the root element from the HTML page
// The empty div with an id of root
const root = ReactDOM.createRoot(document.getElementById('root'));

// Takes that element and renders our entire Virtual DOM to it
root.render(
  // Strict mode is dev only
  // <React.StrictMode>
  // This gives my whole App access to the store
  <Provider store={store}>
    <App2 />
  </Provider>
  // </React.StrictMode>
);