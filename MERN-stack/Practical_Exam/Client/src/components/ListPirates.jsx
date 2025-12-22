import React, { useEffect } from "react";
import axios from "axios";
import DeleteComponent from "./DeleteComponent";
import { useNavigate } from "react-router-dom";
import Apipirates from "../Functions/Apipirates";

const ListPirates = ({ pirates, setPirates }) => {
  const navigate = useNavigate();
  const { fetchPirates } = Apipirates({ pirates, setPirates });

  const handleDelete = (id) => {
    const updatedPirates = pirates.filter((pirate) => pirate._id !== id);
    setPirates(updatedPirates);
  };
  useEffect(() => {
    const fetchallPirates = async () => {
      await fetchPirates();
    };
    fetchallPirates();
  }, []);
  return (
    <div className="flex flex-col h-[80%] pb-20">
      {pirates.map((pirate) => (
        <div
          key={pirate._id}
          className="w-1/2 bg-white border-2 border-black flex justify-between mx-auto mt-10"
        >
          <img
            src={pirate.img}
            alt={pirate.name}
            className="w-[250px] h-[250px]"
          />
          <div className="flex flex-col justify-between py-10 pr-20 mr-20">
            <p className="p-2 text-center text-2xl">{pirate.name}</p>

            <div className="p-2 text-center flex gap-5 mx-auto">
              <button
                className="border-2 border-black p-2 bg-green-600 cursor-pointer text-white"
                onClick={() => navigate(`/pirates/${pirate._id}/details`)}
              >
                View profile
              </button>
              <DeleteComponent id={pirate._id} handleDelete={handleDelete} />
            </div>
          </div>
        </div>
      ))}
    </div>
  );
};

export default ListPirates;
