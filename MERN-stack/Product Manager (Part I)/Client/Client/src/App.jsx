import { Routes, Route } from "react-router-dom";
import "./App.css";
import Form from "./components/form";
import Product from "./components/product";
import Edit from "./components/Edit";
function App() {
  return (
    <>
      <Routes>
        {/* <Route path="/products/:id" element={<Product />} /> */}
        <Route path="/products/:id" element={<Edit />} />
        <Route path="/" element={<Form />} />
      </Routes>
    </>
  );
}

export default App;
