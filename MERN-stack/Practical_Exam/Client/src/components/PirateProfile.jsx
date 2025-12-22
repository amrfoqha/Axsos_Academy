import React, { useEffect, useState } from "react";
import SeeCrewComponent from "./SeeCrewComponent";
import { useNavigate, useParams } from "react-router-dom";
import Apipirates from "../Functions/Apipirates";

export const PirateProfile = () => {
  const [pirate, setPirate] = useState({});
  const navigate = useNavigate();
  const { id } = useParams();
  const { getPirates } = Apipirates({});
  useEffect(() => {
    const fetchPirate = async () => {
      try {
        const res = await getPirates(id);
        setPirate(res);
      } catch (error) {
        console.log(error);
        navigate("/pirates");
      }
    };
    fetchPirate();
  }, []);
  return (
    <div className="w-full h-screen bg-[#ff9900]">
      <header className="bg-[#b45f06] h-28 text-[#4a3a2b] font-bold flex justify-end pr-18">
        <div className="flex items-center justify-between w-1/2 mr-14">
          <p className="text-4xl">{pirate.name}</p>
          <SeeCrewComponent />
        </div>
      </header>
      <div className="flex flex-col  w-[full] h-[70%] px-[15%] mt-20 text-2xl">
        <div className="flex gap-2 w-full justify-between mx-auto h-[400px]">
          <div className="flex flex-col items-center justify-between w-1/2">
            <img src={pirate.img} alt="" className="h-[320px] w-[40%] " />
            <p className="text-2xl font-bold pb-4 text-[#4a3a2b]">
              " {pirate.phrase} "
            </p>
          </div>
          <div className="border border-black p-2 bg-white w-1/2 text-center flex flex-col gap-2 mx-auto">
            <p className="text-3xl font-black ">About</p>
            <p>
              postion: <span className="text-red-800">{pirate.position}</span>
            </p>
            <p>
              treasure: <span className="text-red-800">{pirate.treasure}</span>
            </p>
            <p>
              pegLeg:{" "}
              <span className="text-red-800">
                {pirate.pegLeg ? "Yes" : "No"}
              </span>
            </p>
            <p>
              eyePatch:{" "}
              <span className="text-red-800">
                {pirate.eyePatch ? "Yes" : "No"}
              </span>
            </p>
            <p>
              hookHand:{" "}
              <span className="text-red-800">
                {pirate.hookHand ? "Yes" : "No"}
              </span>
            </p>
          </div>
        </div>
        <button
          className="py-1 bg-white border text-black border-black cursor-pointer hover:bg-[#ff9900] hover:text-white text-xl w-1/5 mx-auto mt-10"
          onClick={() => navigate(`/pirates/${pirate._id}/update`)}
        >
          Edit <span className="text-red-800">{pirate.name}</span> Profile
        </button>
      </div>
    </div>
  );
};

export default PirateProfile;
