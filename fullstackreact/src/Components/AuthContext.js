import React, { createContext, useContext, useState } from 'react';

const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [user, setUser] = useState(null);

  const login = (userData) => {
    // You can set user data, token, or perform authentication logic here.
    setUser(userData);
  };

 
  const logout = () => {
    // Clear user data or token and perform logout logic here.
    localStorage.removeItem('token'); // Remove the token from local storage
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}
