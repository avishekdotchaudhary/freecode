import "./App.css";
import { HomePage } from "./pages/HomePage.jsx";
import { Routes, Route } from "react-router";
import { CheckoutPage } from "./pages/CheckoutPage.jsx";

function App() {
  return (
    <>
      <Routes>
        <Route index element={<HomePage />} />
        <Route path="checkout" element={<CheckoutPage />} />
      </Routes>
    </>
  );
}

export default App;
