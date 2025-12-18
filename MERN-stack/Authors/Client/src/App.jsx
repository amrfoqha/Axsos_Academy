import { useState } from "react";
import "./App.css";
import CreateForm from "./components/CreateForm";
import { Route, Routes } from "react-router-dom";
import Authors from "./components/Authors";
import UpdateForm from "./components/UpdateForm";

function App() {
  return (
    <>
      <Routes>
        <Route path="/authors/new" element={<CreateForm />} />
        <Route path="/" element={<Authors />} />
        <Route path="/authors" element={<Authors />} />
        <Route path="/authors/update/:id" element={<UpdateForm />} />
      </Routes>
    </>
  );
}

export default App;
