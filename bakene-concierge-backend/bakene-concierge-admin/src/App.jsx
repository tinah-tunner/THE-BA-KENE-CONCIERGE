import "./App.css";

function Card({ title, value, icon }) {
  return (
    <div className="card">
      <div className="icon">{icon}</div>
      <h3>{title}</h3>
      <h1>{value}</h1>
    </div>
  );
}

function App() {
  return (
    <div className="container">

      <h1>BA KENE Concierge</h1>

      <p className="subtitle">
        Customer Management Dashboard
      </p>

      <div className="cards">

        <Card
          title="Conversations"
          value="15"
          icon="💬"
        />

        <Card
          title="Bookings"
          value="4"
          icon="📅"
        />

        <Card
          title="Support Tickets"
          value="2"
          icon="🎫"
        />

        <Card
          title="New Distributors"
          value="6"
          icon="👥"
        />

      </div>

      <div className="section">

        <h2>Today's Bookings</h2>

        <table>

          <thead>
            <tr>
              <th>Name</th>
              <th>Date</th>
              <th>Time</th>
              <th>Status</th>
            </tr>
          </thead>

          <tbody>

            <tr>
              <td>John</td>
              <td>Tuesday</td>
              <td>09:00</td>
              <td>Pending</td>
            </tr>

            <tr>
              <td>Mary</td>
              <td>Thursday</td>
              <td>11:00</td>
              <td>Confirmed</td>
            </tr>

          </tbody>

        </table>

      </div>

      <div className="section">

        <h2>Recent Conversations</h2>

        <table>

          <thead>
            <tr>
              <th>Phone</th>
              <th>Current Step</th>
              <th>Status</th>
            </tr>
          </thead>

          <tbody>

            <tr>
              <td>082*******</td>
              <td>Skin Type</td>
              <td>Active</td>
            </tr>

            <tr>
              <td>073*******</td>
              <td>Booking</td>
              <td>Waiting</td>
            </tr>

          </tbody>

        </table>

      </div>

    </div>
  );
}

export default App;