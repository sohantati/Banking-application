import { useState } from "react";

function App() {
  const [userId, setUserId] = useState(1);
  const [balance, setBalance] = useState(0);

  const fetchBalance = async () => {
    const res = await fetch(`https://bank-backend-adap.onrender.com/api/auth/balance/${userId}`);
    const data = await res.json();
    setBalance(data.balance);
  };

  const deposit = async () => {
    await fetch(`https://bank-backend-adap.onrender.com/api/auth/deposit/${userId}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ amount: 50 })
    });
    fetchBalance();
  };

  return (
    <div>
      <h2>Bank Dashboard</h2>
      <p>Balance: {balance}</p>
      <button onClick={fetchBalance}>Refresh Balance</button>
      <button onClick={deposit}>Deposit 50</button>
    </div>
  );
}

export default App;
