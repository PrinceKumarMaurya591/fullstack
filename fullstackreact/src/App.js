import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes,Navigate } from 'react-router-dom';
import Registration from './Components/RegistrationForm';
import Login from './Components/Login';
import Dashboard from './Components/Dashboard';
import Healthcheck from './Components/Healthcheck';
import { AuthProvider, useAuth } from './Components/AuthContext';
import UserList from './Components/UserList';


function App() {
  const [healthResponse, setHealthResponse] = useState(''); // State for health response

  return (
    <AuthProvider>
      <Router>
        <Routes>
          <Route path="/Register" element={<Registration />} />
          <Route path="/login" element={<Login />} />
          <Route
            exact
            path="/login/dashboard/*"
            element={<Dashboard />} 
          />
          <Route exact path="/login/dashboard/health-check" element={<Healthcheck />} /> {/* Add the Healthcheck route */}
          <Route exact path="/login/dashboard/reg" element={<UserList />} />
         
          <Route index element={<Navigate to="/login" />} />
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;
