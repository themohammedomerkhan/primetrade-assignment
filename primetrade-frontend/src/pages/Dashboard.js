import { useNavigate } from "react-router-dom";

function Dashboard() {

  const navigate = useNavigate();

  const logout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };

  return (
    <div>

      <h2>Dashboard</h2>

      <button onClick={() => navigate("/tasks")}>
        Manage Tasks
      </button>

      <br /><br />

      <button onClick={logout}>
        Logout
      </button>

    </div>
  );
}

export default Dashboard;
