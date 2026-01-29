import { useState } from "react";
import API from "../api/api";
import { useNavigate } from "react-router-dom";

function Register() {

  const navigate = useNavigate();

  const [form, setForm] = useState({
    name: "",
    contact: "",
    email: "",
    password: ""
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleRegister = async (e) => {
    e.preventDefault();

    try {

      await API.post("/api/auth/register", form);

      alert("Registration Successful");
      navigate("/");

    } catch (err) {
      alert("Registration Failed");
    }
  };

  return (
    <div>
      <h2>Register</h2>

      <form onSubmit={handleRegister}>

        <input name="name" placeholder="Name" onChange={handleChange} />
        <br />

        <input name="contact" placeholder="Contact" onChange={handleChange} />
        <br />

        <input name="email" placeholder="Email" onChange={handleChange} />
        <br />

        <input name="password" placeholder="Password" type="password" onChange={handleChange} />
        <br />

        <button type="submit">Register</button>

      </form>
    </div>
  );
}

export default Register;
