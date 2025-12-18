import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import Form from "./Form";

const UpdateForm = () => {
  const { id } = useParams();

  const Navigate = useNavigate();
  const [text, setText] = useState("");
  const [nameError, setNameError] = useState("");

  useEffect(() => {
    const fun = async () => {
      try {
        const temp = await axios.get(`http://localhost:8000/api/authors/${id}`);
        setText(temp.data.name);
      } catch (error) {
        console.log(error);
      }
    };
    fun();
  }, []);
  const updateAuthor = async () => {
    try {
      await axios.put("http://localhost:8000/api/authors/" + id, {
        name: text,
      });
      console.log("update success");
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
    Navigate("/");
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
      <p className="text-3xl text-start mt-5 mb-2 ml-2 ">Update Author:</p>
      <Form
        handleProps={updateAuthor}
        setText={setText}
        nameError={nameError}
        setNameError={setNameError}
        cancel={cancel}
        author={text}
      />
    </div>
  );
};

export default UpdateForm;
