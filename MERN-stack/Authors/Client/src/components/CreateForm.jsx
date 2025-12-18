import axios from "axios";
import React, { useState } from "react";
import { Link, Navigate, useNavigate } from "react-router-dom";
import Form from "./Form";

const CreateForm = () => {
  const Navigate = useNavigate();
  const [text, setText] = useState("");
  const [nameError, setNameError] = useState("");

  const cancel = () => {
    setText("");
    setNameError("");
    Navigate("/");
  };

  const createAuthor = async () => {
    try {
      await axios.post("http://localhost:8000/api/authors", {
        name: text,
      });
      console.log("create success");
      //   setAuthor(author);
      cancel();
    } catch (error) {
      setNameError(
        error.response?.data?.errors?.name?.message ||
          "Author Name must be more than 3 chars!"
      );
    }
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
      <Form
        handleProps={createAuthor}
        setText={setText}
        nameError={nameError}
        setNameError={setNameError}
        cancel={cancel}
        author={text}
      />
    </div>
  );
};

export default CreateForm;
