import React from "react";
import { Link } from "react-router-dom";
const NavbarComponent = () => {
  return (
    <div>
      <div className="flex gap-2 text-2xl">
        <Link to="list">Manage Players</Link>
        <span>|</span>
        <Link to="/status/game/1">Manage Player Status</Link>
      </div>
    </div>
  );
};

export default NavbarComponent;
