import { useState } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "./App.css";
import Form from "./components/form";
import Product from "./components/product";
function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <Routes>
        <Route path="/products/:id" element={<Product />} />
        <Route path="/" element={<Form />} />
      </Routes>
    </>
  );
}

export default App;
