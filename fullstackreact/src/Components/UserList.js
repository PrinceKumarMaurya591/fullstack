import React, { useState, useEffect } from 'react';
import axios from 'axios';

const UserList = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const token = localStorage.getItem('token');
    console.log('token: ' + token);

    if (!token) {
      // Handle the case when the token is missing or not authenticated
      // You can redirect to the login page or perform any other action here.
      return;
    }

    const fetchUserData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/auth/reg', {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });

        setUsers(response.data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching data:', error);
        setLoading(false);
      }
    };

    fetchUserData();
  }, []);

  return (
    <div>
      <h1>User List</h1>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <ul>
          {users.map(user => (
            <li key={user.id}>
              <p>ID: {user.id}</p>
              <p>Name: {user.name}</p>
              <p>Email: {user.email}</p>
              <p>Mobile: {user.mobile}</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default UserList;
