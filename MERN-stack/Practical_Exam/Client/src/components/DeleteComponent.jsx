import React from "react";
import Apipirates from "../Functions/Apipirates";
const DeleteComponent = ({ id, handleDelete }) => {
  const { deletePirates } = Apipirates({});
  const handle = async (id) => {
    deletePirates(id);
    handleDelete(id);
  };
  return (
    <div>
      <button
        onClick={() => handle(id)}
        className="border-3 text-white border-black p-2 bg-red-700 shadow-2xl hover:bg-red-800 hover:text-white cursor-pointer"
      >
        Walk the plank
      </button>
    </div>
  );
};

export default DeleteComponent;
