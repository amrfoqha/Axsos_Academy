import React, { useEffect, useState } from "react";
import NavbarComponent from "./NavbarComponent";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
const PlayerStatusComponent = () => {
  const { id: num } = useParams();
  const game = `game${num}`;

  const [players, setPlayers] = useState([]);
  useEffect(() => {
    const fetchPlayer = async () => {
      try {
        const res = await axios.get("http://localhost:8000/api/teams");
        setPlayers(res.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchPlayer();
  }, []);
  const handleStatus = async (id, status) => {
    try {
      await axios.patch(`http://localhost:8000/api/teams/${id}`, {
        game,
        status,
      });
      const updatedPlayers = players.map((player) =>
        player._id === id
          ? { ...player, status: { ...player.status, [game]: status } }
          : player
      );
      setPlayers(updatedPlayers);
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div>
      <div className="flex gap-2 justify-center mt-5 text-xl">
        <Link to="/status/game/1">
          <span
            className={`${
              num == 1
                ? "underline text-blue-500 text-2xl transition-all duration-400 "
                : ""
            }`}
          >
            Game 1
          </span>
        </Link>
        <Link to="/status/game/2">
          <span
            className={`${
              num == 2
                ? "underline text-blue-500 text-2xl transition-all duration-400 "
                : ""
            }`}
          >
            Game 2
          </span>
        </Link>
        <Link to="/status/game/3">
          <span
            className={`${
              num == 3
                ? "underline text-blue-500 text-2xl transition-all duration-400 "
                : ""
            }`}
          >
            Game 3
          </span>
        </Link>
      </div>
      <table className="border-2 border-black w-full border-collapse mt-5">
        <thead className="border-2 border-black text-xl">
          <tr>
            <th className="px-2 py-2 border-r-2 border-black">Player Name</th>
            <th className="px-2 py-2 border-r-2 border-black">Actions</th>
          </tr>
        </thead>
        <tbody>
          {players.map((player) => (
            <tr key={player._id} className="border-2 border-black text-xl">
              <td className="px-2 py-2 border-r-2 border-black">
                {player.name}
              </td>
              <td className="flex gap-2 py-2 px-2">
                <button
                  className={`border-2 border-black p-2 ${
                    player.status[game] === "Playing" ? "bg-green-500" : ""
                  } transition-all duration-400`}
                  onClick={() => handleStatus(player._id, "Playing")}
                >
                  Playing
                </button>
                <button
                  className={`border-2 border-black p-2 ${
                    player.status[game] === "Not Playing" ? "bg-red-500" : ""
                  } transition-all duration-400`}
                  onClick={() => handleStatus(player._id, "Not Playing")}
                >
                  Not Playing
                </button>
                <button
                  className={`border-2 border-black p-2 ${
                    player.status[game] === "Undecided" ? "bg-yellow-500" : ""
                  } transition-all duration-400`}
                  onClick={() => handleStatus(player._id, "Undecided")}
                >
                  Undecided
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PlayerStatusComponent;
