import "./App.css";
import { HomePage } from "./pages/HomePage.jsx";
import { Routes, Route } from "react-router";

function App() {
  return (
    <>
      <Routes>
        <Route index element={<HomePage />} />
        <Route path="/checkout" element={<>Test Checkout Page</>}></Route>
      </Routes>
    </>
  );
}

export default App;
