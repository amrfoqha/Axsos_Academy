import { Routes, Route, Link } from "react-router-dom";
import "./App.css";
import HomeComponent from "./Component/HomeComponent";
import NumberComponent from "./Component/NumberComponent";
import ColorComponent from "./Component/ColorComponent";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<h1>hhhhhh this root page</h1>} />
        <Route path="/home" element={<HomeComponent />} />
        <Route path="/:param" element={<NumberComponent />} />
        <Route path="/:param/:color1/:color2" element={<ColorComponent />} />
      </Routes>
    </>
  );
}

export default App;
