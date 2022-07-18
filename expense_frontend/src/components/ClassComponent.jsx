import React from "react";
// Class based components "Classical Components" were the way to write components with state 
// back before version 16.8

// Inheritance allows this class to be treated as a React component
export class ClassComponent extends React.Component {

    constructor() {
        super();
        this.state = {
            count: 0
        };
        // Binds all references of 'this' to the actual object we're calling it with
        // Not necessary for arrow functions
        this.increment = this.increment.bind(this);
    }

    increment() {
        // Calling setState is what tells the Virtual DOM to re-render
        this.setState({count: this.state.count + 1});
    }

    decrement = () => {
        this.setState({count: this.state.count - 1});
    }

    // These are life cycle methods
    // They run at various stages in a component's lifecycle

    // This runs right when this component first mounts to the DOM (similar to init() from Servlets)
    componentDidMount() {
        // This is a good place to make API calls
        // We might also set up some event listeners on this element
        // Maybe a setInterval is set up here or a web socket connection
        console.log('Component is born!');
    }

    // This runs after every re-render of this component
    componentDidUpdate(prevProps, prevState) {
        // I can step into the rerender process and run some extra code if the state did change
        
        // Only run this code when count changes
        if (prevState.count !== this.state.count) {
            console.log('Count changed! New state: ' + this.state.count);
        }
    }

    // This runs just before this component is about to be unmounted from the DOM (similar to destroy() from Servlets)
    componentWillUnmount() {
        // Any connections established during mount phase or elsewhere should be severed here
        // Also, clearInterval or clearTimeout should be done here as well
        // Any active API calls should be aborted in here
        console.log('Component is about to be unborn!');
    }

    // We must override the render method to display the JSX
    render() {
        // In here, I will return the JSX
        return (
            <>
                <h1>Hello Class Component!</h1>
                {/* `${this.state.count}` with a template string */}
                <h2>Current Count: {this.state.count}</h2>
                {/* They click on the button, that activates this arrow function, that arrow function
                    calls alert function

                    Currying
                */}
                <button onClick={this.increment}>+</button>
                <button onClick={this.decrement}>-</button>
            </>
        );
    }

}