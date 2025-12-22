import React from "react";
import { useNavigate } from "react-router-dom";
const SeeDetailsComponent = ({ id }) => {
  const navigate = useNavigate();
  return (
    <button
      className="px-3 py-1 bg-white border text-black border-black cursor-pointer hover:bg-[#ff9900] hover:text-white text-xl"
      onClick={() => navigate(`/pirates/${id}/details`)}
    >
      See Details
    </button>
  );
};

export default SeeDetailsComponent;
