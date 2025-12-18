import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const CreateForm = () => {
  const navigate = useNavigate();
  const [text, setText] = useState("");
  const [nameError, setNameError] = useState("");

  const validateName = (e) => {
    const value = e.target.value;
    setText(value);

    if (value.length > 0 && value.length < 3) {
      setNameError("Author name must be at least 3 characters");
    } else {
      setNameError("");
    }
  };
  const handleSubmit = async (e) => {
    e.preventDefault();
    await createAuthor();
  };
  const createAuthor = async () => {
    try {
      await axios.post("http://localhost:8000/api/authors", {
        name: text,
      });
      console.log("success");
      //   setAuthor(author);
      cancel();
    } catch (error) {
      setNameError(
        error.response?.data?.errors?.name?.message ||
          "Author Name must be more than 3 chars!"
      );
    }
  };
  const cancel = () => {
    setText("");
    setNameError("");
    navigate("/");
  };

  return (
    <div>
      <h1 className="text-7xl">Favorite authors</h1>
      <Link
        to={"/"}
        className="text-blue-700 underline hover:text-blue-400 text-2xl"
      >
        Home
      </Link>
      <p className="text-3xl text-start mt-5 mb-2 ml-2 ">Add new Author:</p>
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
          />
          {nameError && <p className="text-red-700 text-sm">{nameError}</p>}
        </div>
        <div className="mt-12 flex gap-5 justify-center">
          <button onClick={cancel}>Cancel</button>
          <button onClick={handleSubmit}>Submit</button>
        </div>
      </form>
    </div>
  );
};

export default CreateForm;
