import React from "react";
import deleteIcon from "../assets/dev-icon-61.svg";
import axios from "axios";
import { useNavigate } from "react-router-dom";
function DeleteButton({ id, setProducts, products }) {
  const navigate = useNavigate();
  const deleteProduct = (id) => {
    try {
      axios.delete(`http://localhost:8000/api/products/${id}`);
      setProducts(products.filter((product) => product._id !== id));
      navigate("/");
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <button
      className="flex items-center justify-center "
      onClick={() => deleteProduct(id)}
    >
      <img src={deleteIcon} alt="delete" className="w-5 mr-2" />
      delete
    </button>
  );
}

export default DeleteButton;
