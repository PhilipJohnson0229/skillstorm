export const Home = () => {
    return (
        // This is how to read environment variables
        // Environment variables are good to toggle between different environments (dev, prod, test, QA)
        <>
            <h1>{process.env.REACT_APP_MESSAGE}</h1>
            <h2>Make a request to {process.env.REACT_APP_HOST_URI}/accounts to see all accounts</h2>
        </>
    );
}