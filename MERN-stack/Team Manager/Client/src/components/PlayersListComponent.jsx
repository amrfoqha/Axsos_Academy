import React from "react";
import NavbarComponent from "./NavbarComponent";
import { Link, Outlet } from "react-router-dom";
const PlayersListComponent = () => {
  return (
    <div className="flex flex-col gap-5 w-[600px] mt-5">
      <div className="border-2 border-black p-4">
        <div className="flex gap-5 text-xl mb-4">
          <Link to="list">List</Link>
          <Link to="addplayer">Add Player</Link>
        </div>
        <Outlet />
      </div>
    </div>
  );
};

export default PlayersListComponent;
