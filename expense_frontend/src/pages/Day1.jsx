import { useState } from "react";
import { ClassComponent } from "../components/ClassComponent";
import { FunctionComponent } from "../components/FunctionComponent";
import { SoftwareDeveloperList } from "../components/SoftwareDeveloper";

export const Day1 = () => {
    const [shouldRender, setShouldRender] = useState(false);
    
    // Whatever is returned from this function will be rendered to the page
    return (
        // You may only return ONE JSX element per function
        // This is a fragment. Fragments allow us to return multiple JSX elements
        // They do NOT render to the webpage
        <>
            <button onClick={() => setShouldRender(!shouldRender)}>Toggle Components</button>
            <h1>Hello React!</h1>
            <h2>Hello Again!</h2>
            <SoftwareDeveloperList />
            
            {/* Calling our ClassComponent this way will auto call render() on our behalf */}
            {/* If shouldRender is true, render ClassComponent. If false, return false. False does NOT render */}
            {/* This is known as "conditional rendering" */}
            {shouldRender && <ClassComponent />}
            {shouldRender ? <FunctionComponent /> : null}
            {/* <ClassComponent /> */}
        </>
    );

    // If we return multiple with no fragment, we'd try to return two things like this (which we can't do)
    // React.createElement("h1", null, "Hello React!");
    // React.createElement("h2", null, "Hello Again!");
}