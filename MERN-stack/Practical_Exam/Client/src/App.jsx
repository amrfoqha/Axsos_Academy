import React, { useState } from "react";
import "./App.css";
import HomeComponent from "./components/HomeComponent";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import CreatePiratesForm from "./components/CreatePiratesForm";
import { Navigate } from "react-router-dom";
import ListPirates from "./components/ListPirates";
import PirateProfile from "./components/PirateProfile";
import EditPiratesForm from "./components/EditPiratesForm";
function App() {
  const [pirates, setPirates] = useState([]);
  return (
    <>
      <Routes>
        <Route path="/pirates" element={<HomeComponent />}>
          <Route
            index
            element={<ListPirates pirates={pirates} setPirates={setPirates} />}
          />
        </Route>
        <Route path="/pirates/add" element={<CreatePiratesForm />} />
        <Route path="/pirates/:id/details" element={<PirateProfile />} />
        <Route path="/pirates/:id/update" element={<EditPiratesForm />} />
        <Route path="*" element={<Navigate to="pirates" />} />
      </Routes>
    </>
  );
}

export default App;
