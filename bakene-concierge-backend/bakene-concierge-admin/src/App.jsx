import "./App.css";
import { useEffect, useState } from "react";

function App() {

  const [dashboard, setDashboard] = useState({
    totalConversations: 0,
    totalMessages: 0,
    conversations: []
  });

  useEffect(() => {
    loadDashboard();

    const timer = setInterval(() => {
      loadDashboard();
    }, 5000);

    return () => clearInterval(timer);

  }, []);

  async function loadDashboard() {

    const response = await fetch(
      "https://the-ba-kene-concierge.onrender.com/api/admin/dashboard"
    );

    const data = await response.json();

    setDashboard(data);
  }

  return (
    <div className="container">

      <h1>BA KENE Concierge</h1>

      <p className="subtitle">
        Live Customer Management Dashboard
      </p>

      <div className="cards">

        <div className="card">
          <h3>Conversations</h3>
          <h1>{dashboard.totalConversations}</h1>
        </div>
<tbody>

{dashboard.conversations.map((conversation) => (

<tr
  key={conversation.id}
  onClick={() => window.location.href = `/conversation/${conversation.id}`}
  style={{ cursor: "pointer" }}
>

<td>{conversation.whatsappNumber}</td>

<td>{conversation.userType}</td>

<td>{conversation.currentStep}</td>

<td>{conversation.skinType || "-"}</td>

<td>{conversation.skinConcern || "-"}</td>

<td>{conversation.status}</td>

</tr>

))}

</tbody>

      

      </div>

    </div>
  );
}

export default App;