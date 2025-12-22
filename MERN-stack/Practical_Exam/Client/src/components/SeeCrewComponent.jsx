import React from "react";
import { useNavigate } from "react-router-dom";
function SeeCrewComponent() {
  const navigate = useNavigate();
  return (
    <button
      className="px-3 py-1 bg-white border text-black border-black cursor-pointer hover:bg-[#ff9900] hover:text-white text-xl"
      onClick={() => navigate("/pirates")}
    >
      See Crew
    </button>
  );
}

export default SeeCrewComponent;
