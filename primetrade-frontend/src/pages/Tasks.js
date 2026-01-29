import { useState, useEffect } from "react";
import API from "../api/api";

function Tasks() {

  const [tasks, setTasks] = useState([]);
  const [title, setTitle] = useState("");

  const loadTasks = async () => {
    const res = await API.get("/api/tasks/my");
    setTasks(res.data);
  };

  useEffect(() => {
    loadTasks();
  }, []);

  const createTask = async () => {

    await API.post("/api/tasks", {
      title: title,
      status: "PENDING",
      priority: "HIGH"
    });

    setTitle("");
    loadTasks();
  };

  const deleteTask = async (id) => {
    await API.delete(`/api/tasks/${id}`);
    loadTasks();
  };

  return (
    <div>

      <h2>My Tasks</h2>

      <input
        placeholder="Task Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />

      <button onClick={createTask}>
        Add Task
      </button>

      <ul>
        {tasks.map(task => (
          <li key={task.id}>
            {task.title}
            <button onClick={() => deleteTask(task.id)}>Delete</button>
          </li>
        ))}
      </ul>

    </div>
  );
}

export default Tasks;
