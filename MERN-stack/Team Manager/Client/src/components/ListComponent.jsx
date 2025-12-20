import React, { useEffect, useState } from "react";
import axios from "axios";
import DeleteComponent from "./DeleteComponent";

const ListComponent = () => {
  const [players, setPlayers] = useState([]);
  useEffect(() => {
    const fetchPlayers = async () => {
      try {
        const res = await axios.get("http://localhost:8000/api/teams");
        setPlayers(res.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchPlayers();
  }, []);
  const handleDelete = (id) => {
    const updatedPlayers = players.filter((player) => player._id !== id);
    setPlayers(updatedPlayers);
  };
  return (
    <table className="border-2 border-black w-full border-collapse">
      <thead>
        <tr className="border-2 border-black">
          <th className="p-2 text-start text-2xl">Team Name</th>
          <th className="p-2 text-start text-2xl">Prefered Position</th>
          <th className="p-2 text-start text-2xl">Actions</th>
        </tr>
      </thead>
      <tbody>
        {players.map((player) => (
          <tr key={player._id}>
            <td className="p-2 text-center ">{player.name}</td>
            <td className="p-2 text-center ">{player.position}</td>
            <td className="p-2 text-center ">
              <DeleteComponent id={player._id} handleDelete={handleDelete} />
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default ListComponent;
