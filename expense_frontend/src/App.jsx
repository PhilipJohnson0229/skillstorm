import { useState } from 'react';
import { useSelector } from 'react-redux';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { StatusPage, Day2, Home, Error, ReduxExample } from "./pages";
import { Navigation } from './components/Navigation';
import { Link } from 'react-router-dom';
import ThemeContext, { themes } from './contexts/ThemeContext';
import 'bootstrap/dist/css/bootstrap.min.css'
import { MyFooter } from './components/MyFooter';
// React believes that a function should determine the UI output

// "named" export
// Named exports are all exported in a singular object
export const App = () => {
    const [currTheme, setCurrTheme] = useState(themes.light);
    
    const toggleTheme = () => setCurrTheme(currTheme === themes.light ? themes.dark : themes.light)

    return (
        <ThemeContext.Provider value={currTheme}>
       
        <BrowserRouter>
            <Navigation>
                {/* Component Composition */}
                <section className='nav-section'>
                    {/* Anchor tags refresh the page. Instead, I'll use Link from React-Router-dom */}
                    {/* <a href="/day1">Day1</a> */}
                    <div className='nav-item'>
                        <Link className="nav-item" to="/">Home</Link>
                    </div>
                    <div className='nav-item'>
                        <Link className="nav-item" to="/StatusPage">Reimbursements</Link>
                    </div>
                    <div className='nav-item'>
                        <Link className="nav-item" to="/Error">Contact</Link>
                    </div>
                </section>
                <section className='nav-section'>
                    <button onClick={toggleTheme}>Toggle Theme</button>
                    <div className='nav-item'>Sign In</div>
                    <div className='nav-item'>Sign Up</div>
                </section>
            </Navigation>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/StatusPage" element={<StatusPage />} />
                <Route path="/Error" element={<Error />} />
            </Routes>
           
        </BrowserRouter>

        <MyFooter/>
        </ThemeContext.Provider> 
       
    );
}

export const two = 2;

// { App: App, two: two }

// I need to export App

// 2 ways to export

// default export
// You may only have 1 default export per file
export default App;

