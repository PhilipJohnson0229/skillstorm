import { configureStore } from '@reduxjs/toolkit';
import counter from './slices/counter';

// configureStore returns a store to use
export const store = configureStore({
    reducer: {
        // Reducer contains separate functions that handle specific actions
        counter,
        // add more reducers here
    }
});