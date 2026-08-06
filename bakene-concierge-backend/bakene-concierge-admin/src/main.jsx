import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import Conversation from "./Conversation.jsx";
import "./index.css";

const path = window.location.pathname;

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    {path.startsWith("/conversation/")
      ? <Conversation />
      : <App />}
  </React.StrictMode>
);