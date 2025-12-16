import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

function Product() {
  const [product, setProduct] = useState({});
  const { id } = useParams();
  useEffect(() => {
    axios
      .get(`http://localhost:8000/api/products/${id}`)
      .then((res) => {
        setProduct(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [id]);
  return (
    <div className="w-[500px] text-2xl">
      <h1 className=" text-black flex justify-between">
        <span className="font-bold">Title:</span> {product.title}
      </h1>
      <p className="text-black flex justify-between">
        <span className="font-bold">Price:</span> {product.price}
      </p>
      <p className="text-black flex justify-between">
        <span className="font-bold">Description:</span> {product.description}
      </p>

      <Link to="/">
        <p className="mt-10 hover:underline">Back to Home</p>
      </Link>
    </div>
  );
}

export default Product;
