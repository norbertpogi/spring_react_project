import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import ProjectBoard from './components/ProjectBoard';
import NavBar from './components/Navbar';

function App() {
  return (
      <div className="App">
        <NavBar />
        <ProjectBoard />
      </div>    
  );
}

export default App;
