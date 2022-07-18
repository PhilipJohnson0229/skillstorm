import { useRef } from 'react';
import { useSelector, useDispatch } from "react-redux";
import { increment, decrement, setCount } from "../slices/counter";
// To read from the store, redux provides us a hook

export const ReduxExample = () => {

    // useSelector allows us to pull out what we want from the global store
    // Doing so will auto re-render this component when that value changes
    const store = useSelector(store => store);
    const dispatch = useDispatch();

    const inputRef = useRef();

    console.log(store);
    // This component will update the count

    const handleClick = () => {
        // Cast to a number
        // The parameter sent to setCount will be available in the action.payload property
        dispatch(setCount(Number(inputRef.current.value)));
        inputRef.current.value = null;
    }

    return (
        <div>
            <h1>Redux Counter Controller</h1>
            <h2>Count: {store.counter.count}</h2>
            <button onClick={() => dispatch(increment())}>+</button>
            <button onClick={() => dispatch(decrement())}>-</button>
            <div>
                <input type="number" ref={inputRef}/>
                <button onClick={handleClick}>Set Count</button>
            </div>
        </div>
    );
}