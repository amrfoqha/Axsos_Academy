import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import DeleteButton from "./DeleteButton";
import { useNavigate } from "react-router-dom";
const Edit = () => {
  const [title, setTitle] = useState("");
  const [price, setPrice] = useState("");
  const [description, setDescription] = useState("");
  const [titleError, setTitleError] = useState(false);
  const [priceError, setPriceError] = useState(false);
  const [descriptionError, setDescriptionError] = useState(false);
  const { id } = useParams();
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    updateProduct({ title, price, description });
  };
  const updateProduct = (product) => {
    axios
      .patch(`http://localhost:8000/api/products/${id}`, product)
      .then(() => {
        navigate("/");
      })
      .catch((err) => console.log(err));
  };

  const validateTitle = (e) => {
    const value = e.target.value;
    setTitle(value);
    setTitleError(value.length > 0 && value.length < 2);
  };
  const validatePrice = (e) => {
    const value = e.target.value;
    setPrice(value);
    setPriceError(value.length > 0 && isNaN(value));
  };
  const validateDescription = (e) => {
    const value = e.target.value;
    setDescription(value);
    setDescriptionError(value.length > 0 && value.length < 5);
  };
  useEffect(() => {
    axios.get(`http://localhost:8000/api/products/${id}`).then((res) => {
      setTitle(res.data.title);
      setPrice(res.data.price);
      setDescription(res.data.description);
    });
  }, [id]);

  return (
    <div>
      <form
        action="#"
        className=" p-4 text-black w-full text-2xl"
        onSubmit={handleSubmit}
      >
        <div>
          <div className="flex justify-between">
            <label htmlFor="" className="mr-4">
              title
            </label>
            <input
              value={title}
              type="text"
              className="mb-5 border border-black"
              onChange={(e) => validateTitle(e)}
            />
          </div>
          {titleError && (
            <p className="text-sm text-start text-red-700">
              field must be at least 2 characters
            </p>
          )}
        </div>
        <div>
          <div className="flex justify-between">
            <label htmlFor="" className="mr-4">
              price
            </label>
            <input
              value={price}
              type="text"
              className="mb-5 border border-black"
              onChange={(e) => validatePrice(e)}
            />
          </div>
          {priceError && (
            <p className="text-sm text-start text-red-700">
              field must be number
            </p>
          )}
        </div>
        <div>
          <div className="flex justify-between">
            <label htmlFor="" className="mr-4">
              description
            </label>
            <input
              value={description}
              type="text"
              className="mb-5 border border-black"
              onChange={(e) => validateDescription(e)}
            />
          </div>
          {descriptionError && (
            <p className="text-sm text-start text-red-700">
              field must be at least 5 characters
            </p>
          )}
        </div>
        <div className="flex justify-between items-center">
          <button>Save Edit</button>
          <DeleteButton id={id} />
        </div>
      </form>
      <Link to="/" className="mt-5 text-2xl hover:underline hover:text-black">
        Back to Home
      </Link>
    </div>
  );
};

export default Edit;
