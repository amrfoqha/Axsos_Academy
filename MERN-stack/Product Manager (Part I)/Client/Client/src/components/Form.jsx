import React, { useEffect, useState } from "react";
import axios from "axios";

function Form() {
  const [title, setTitle] = useState("");
  const [price, setPrice] = useState("");
  const [description, setDescription] = useState("");
  const [titleError, setTitleError] = useState(false);
  const [priceError, setPriceError] = useState(false);
  const [descriptionError, setDescriptionError] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    createProduct({ title, price, description });
  };
  const createProduct = (product) => {
    axios
      .post("http://localhost:8000/api/products", product)
      .then((res) => {
        console.log(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const validateTitle = (e) => {
    if (e.target.value.length < 2 && e.target.value.length != 0)
      setTitleError(true);
    else {
      setTitleError(false);
      setTitle(e.target.value);
    }
  };
  const validatePrice = (e) => {
    if (e.target.value.length != 0 && isNaN(e.target.value))
      setPriceError(true);
    else {
      setPriceError(false);
      setPrice(e.target.value);
    }
  };
  const validateDescription = (e) => {
    if (e.target.value.length < 5 && e.target.value.length != 0)
      setDescriptionError(true);
    else {
      setDescriptionError(false);
      setDescription(e.target.value);
    }
  };

  return (
    <>
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
        <button className="mt-5">Submit</button>
      </form>
    </>
  );
}

export default Form;
