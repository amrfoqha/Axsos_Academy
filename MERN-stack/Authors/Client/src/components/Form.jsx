import React, { useEffect, useState } from "react";
import { Navigate } from "react-router-dom";

const Form = ({
  handleProps,
  setText,
  setNameError,
  nameError,
  cancel,
  author,
}) => {
  const handleSubmit = async (e) => {
    e.preventDefault();
    await handleProps();
  };
  const validateName = (e) => {
    const value = e.target.value;
    setText(value);

    if (value.length > 0 && value.length < 3) {
      setNameError("Author name must be at least 3 characters");
    } else {
      setNameError("");
    }
  };

  return (
    <form
      action=""
      className="border-2 border-black text-2xl w-[500px] h-[300px] pt-5"
    >
      <div className="flex flex-col justify-between items-start gap-2 pl-[21%] pb-4 pt-0">
        <label>Name: </label>
        <input
          type="text"
          name=""
          id=""
          placeholder="Author Name..."
          className="border-2 border-black p-1 "
          onChange={(e) => validateName(e)}
          value={author || ""}
        />
        {nameError && <p className="text-red-700 text-sm">{nameError}</p>}
      </div>
      <div className="mt-12 flex gap-5 justify-center">
        <button onClick={cancel}>Cancel</button>
        <button onClick={handleSubmit}>Submit</button>
      </div>
    </form>
  );
};

export default Form;
