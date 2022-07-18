import { createSlice } from "@reduxjs/toolkit";
// Since redux toolkit's launch, we now create reducers and actions together in something called a "slice"

const counterSlice = createSlice({
    name: 'counter', // This is how I identify it
    initialState: {
        // this state is local to this slice
        count: 0,
        // Add more state here
    },
    reducers: {
        // These reducers consist of "actions" that I can use to mutate the state
        increment: state => {
            // This gets called when the increment() action is dispatched
            state.count += 1; // Increase count by 1
        },
        decrement: state => {
            state.count -= 1;
        },
        // I need a value to set the count to
        // This action object will contain a payload attribute that holds my count to set
        setCount: (state, action) => {
            state.count = action.payload;
        }
    }
});

export const { increment, decrement, setCount } = counterSlice.actions;
export default counterSlice.reducer;