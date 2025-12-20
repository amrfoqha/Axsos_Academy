import "./App.css";
import PlayersList from "./components/PlayersListComponent.jsx";
import { Routes, Route, Navigate } from "react-router-dom";
import AddPlayer from "./components/AddPlayerComponent.jsx";
import ListComponent from "./components/ListComponent.jsx";
import PlayerStatus from "./components/PlayerStatusComponent.jsx";
import NavbarComponent from "./components/NavbarComponent.jsx";
function App() {
  return (
    <>
      <NavbarComponent />

      <Routes>
        <Route path="/players" element={<PlayersList />}>
          <Route path="list" element={<ListComponent />} />
          <Route path="addplayer" element={<AddPlayer />} />
        </Route>

        <Route path="/status/game/:id" element={<PlayerStatus />} />

        <Route path="*" element={<Navigate to="/players/list" />} />
      </Routes>
    </>
  );
}

export default App;
