import React from "react";
import axios from "axios";
const DeleteComponent = ({ id, handleDelete }) => {
  const handle = async (id) => {
    if (window.confirm("are you sure you want to delete this player")) {
      try {
        await axios.delete(`http://localhost:8000/api/teams/${id}`);
        handleDelete(id);
      } catch (error) {
        console.log(error);
      }
    }
  };
  return (
    <div>
      <button
        onClick={() => handle(id)}
        className="border-3 text-white border-black p-2 bg-red-700 shadow-2xl "
      >
        delete
      </button>
    </div>
  );
};

export default DeleteComponent;
