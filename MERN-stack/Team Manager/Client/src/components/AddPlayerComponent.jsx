import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
const AddPlayerComponent = () => {
  const [name, setName] = useState("");
  const [position, setPosition] = useState("");
  const [error, setError] = useState("");

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post("http://localhost:8000/api/teams", {
        name,
        position,
      });
      console.log(res);
      navigate("/players/list");
    } catch (error) {
      setError(error.response.data.errors.name.message);
    }
  };

  const validatePlayerName = (e) => {
    const value = e.target.value;
    setError(
      value.length < 3 && value.length != 0
        ? "player name must be at least 3 characters long"
        : ""
    );
    setName(value);
  };
  return (
    <div className="flex flex-col gap-5 w-[600px]">
      <h1 className="text-sm">Add Player</h1>
      <form
        onSubmit={handleSubmit}
        className="flex flex-col gap-2 w-[400px] border-2 border-black p-4 self-center mt-4"
      >
        <div>
          <input
            type="text"
            placeholder="Player Name"
            onChange={validatePlayerName}
            className="border-2 border-black p-2 w-full"
          />
          {error && <p className="text-red-500 text-sm">{error}</p>}
        </div>
        <div className="mt-2">
          <input
            type="text"
            placeholder="Prefered Position"
            onChange={(e) => setPosition(e.target.value)}
            className="border-2 border-black p-2 w-full"
          />
        </div>
        <button
          type="submit"
          disabled={error && true}
          className="border-2 border-black p-2 w-1/3 self-center mt-2 "
          style={{ cursor: error ? "not-allowed" : "pointer" }}
        >
          Add Player
        </button>
      </form>
    </div>
  );
};

export default AddPlayerComponent;
