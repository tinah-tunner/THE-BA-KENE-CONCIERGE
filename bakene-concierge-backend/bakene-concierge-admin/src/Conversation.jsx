import { useEffect, useState } from "react";
import "./App.css";

function Conversation() {

  const id = window.location.pathname.split("/").pop();

  const [messages, setMessages] = useState([]);

  useEffect(() => {

    loadMessages();

    const timer = setInterval(loadMessages, 3000);

    return () => clearInterval(timer);

  }, []);

  async function loadMessages() {

    const response = await fetch(
      `https://the-ba-kene-concierge.onrender.com/api/admin/conversation/${id}`
    );

    const data = await response.json();

    setMessages(data);
  }

  return (

    <div className="container">

      <h1>Customer Conversation</h1>

      <button
        className="backButton"
        onClick={() => window.location.href = "/"}
      >
        ← Dashboard
      </button>

      <div className="chatBox">

        {messages.length === 0 ? (

          <div className="emptyChat">
            No messages yet.
          </div>

        ) : (

          messages.map((message) => (

            <div
              key={message.id}
              className={
                message.direction === "OUTGOING"
                  ? "botMessage"
                  : "userMessage"
              }
            >

              <div className="messageHeader">

                <strong>{message.sender}</strong>

                <span>
                  {message.createdAt?.replace("T"," ").substring(0,19)}
                </span>

              </div>

              <div className="messageBody">

                {message.message}

              </div>

            </div>

          ))

        )}

      </div>

    </div>

  );

}

export default Conversation;