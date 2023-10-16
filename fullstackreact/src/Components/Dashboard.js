import React from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';
import { ListGroup, ListGroupItem } from 'reactstrap';
import { useAuth } from './AuthContext';

function Dashboard() {
  const { user, logout } = useAuth();
  const navigate = useNavigate(); // Move the useNavigate hook inside the component function

  const handleLogout = async () => {
    const token = localStorage.getItem('token');

    if (!token) {
      navigate('/'); // Redirect to login if not authenticated
      return;
    }

    try {
      await axios.post('http://localhost:8080/auth/logout', null, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      // Clear user data and token
      logout();
      navigate('/login'); // Redirect to the login page after successful logout
    } catch (error) {
      console.error('Logout failed:', error);
    }
  };

  return (
    <div>
      <h1>Dashboard</h1>
      <p>Welcome</p>
      <button onClick={handleLogout}>Logout</button> {/* Logout button */}
      <ListGroup>
        <ListGroupItem tag={Link} to={`/login/dashboard/health-check`} action>
          Healthcheck
        </ListGroupItem><br/><br/>
        <ListGroupItem tag={Link} to={`/login/dashboard/reg`} action>
          UserList
        </ListGroupItem>
      </ListGroup>
    </div>
  );
}

export default Dashboard;
