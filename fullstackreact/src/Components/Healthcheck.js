
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Navigate } from 'react-router-dom'; // Assuming you're using React Router for navigation

function Healthcheck() {
  const [healthData, setHealthData] = useState({});
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const token = localStorage.getItem('token');
    console.log('token: ' + token);
    
    if (!token) {
      Navigate('/'); // Redirect to login if not authenticated
      return;
    }

    const fetchHealthData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/auth/health', {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });

        setHealthData(response.data);
        setLoading(false);
        console.log('Health Check Response:', response.data);
      } catch (error) {
        console.error('Health Check failed:', error);
      }
    };

    fetchHealthData();
  }, []); // Empty dependency array to run the effect only once

  return (
    <div>
      <h1>Healthcheck</h1>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <div>
          <p>Response from Healthcheck:</p>
          <pre>{JSON.stringify(healthData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
}

export default Healthcheck;
