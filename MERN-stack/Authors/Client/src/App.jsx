import { useState } from "react";
import "./App.css";
import CreateForm from "./components/CreateForm";
import { Route, Routes } from "react-router-dom";
import Authors from "./components/Authors";

function App() {
  return (
    <>
      <Routes>
        <Route path="/authors/new" element={<CreateForm />} />
        <Route path="/" element={<Authors />} />
        <Route path="/authors" element={<Authors />} />
      </Routes>
    </>
  );
}

export default App;
