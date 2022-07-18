import { useState, useEffect } from "react";

// With React 16.8, "hooks were introduced" which added the stateful logic from class components to functions
// Before this, Function components were "dumb" or UI only components (AKA No state)

export const FunctionComponent = () => {

    // All hooks should be top-level of the function
    // Above the return statement and not nested within any blocks (if/for/switch)
    const [count, setCount] = useState(0); // If no value is passed, undefined is the default value for the state

    // This useEffect will run ANY TIME state changes. This is often not what you mean to do
    useEffect(() => {
        console.log('Component updated!');
    });

    // This useEffect will only run when count changes (and on mount)
    useEffect(() => {
        console.log('New count: ' + count);
    }, [count]);// Dependency array. When a value in the array changes, the callback is re-invoked

    // This useEffect is essentially componentDidMount()
    useEffect(() => {
        console.log('Function component is born!');
        const intervalKey = setInterval(() => {
            console.log(new Date());
        }, 1000);

        // If we return a function inside this callback, that will be auto called when unmounting occurs
        return () => {
            // This is my componentWillUnmount
            clearInterval(intervalKey);
        }
    }, []);

    const increment = () => setCount(count + 1);
    const decrement = () => setCount(count - 1);

    return (
        <>
            <h1>Hello Function Component!</h1>
            <h2>Current Count: {count}</h2>
            <button onClick={increment}>+</button>
            <button onClick={decrement}>-</button>
        </>
    );
}