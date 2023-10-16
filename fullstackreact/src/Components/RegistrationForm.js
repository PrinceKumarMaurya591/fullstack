import React, { Component } from 'react';
import axios from 'axios';

class Registration extends Component {
  constructor() {
    super();
    this.state = {
      name: '',
      email: '',
      mobile: '',
      password: '',
    };
  }

  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const { name, email, mobile, password } = this.state;

    // Create a payload object
    const registrationData = {
      name: name,
      email: email,
      mobile: mobile,
      password: password,
    };

    // Send a POST request to the backend
    axios
      .post('http://localhost:8080/registration', registrationData)
      .then((response) => {
        console.log('Registration successful:', response.data);
        // Reset the form or perform any other actions you want
      })
      .catch((error) => {
        console.error('Registration failed:', error);
      });
  };

  render() {
    return (
      <div>
        <h1>Registration</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name:</label>
            <input
              type="text"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label>Email:</label>
            <input
              type="email"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label>Mobile:</label>
            <input
              type="text"
              name="mobile"
              value={this.state.mobile}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label>Password:</label>
            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}

export default Registration;
