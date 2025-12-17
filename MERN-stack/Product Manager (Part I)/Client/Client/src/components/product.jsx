import React, { useEffect, useState } from "react";
import axios from "axios";

import { Link, useParams } from "react-router-dom";
import Skeleton from "@mui/material/Skeleton";

function Product() {
  const [product, setProduct] = useState({});
  const { id } = useParams();
  const [loading, setLoading] = useState(false);
  useEffect(() => {
    setLoading(true);
    axios
      .get(`http://localhost:8000/api/products/${id}`)
      .then((res) => {
        setProduct(res.data);
        setLoading(false);
      })
      .catch((err) => {
        console.log(err);
        setLoading(false);
      });
  }, [id]);
  return (
    <div className="w-[500px] text-2xl">
      <div className=" text-black flex justify-between">
        <span className="font-bold">Title:</span>
        {loading ? (
          <Skeleton variant="text" width={44.238} height={32} />
        ) : (
          <p>{product.title}</p>
        )}
      </div>
      <div className="text-black flex justify-between">
        <span className="font-bold">Price:</span>{" "}
        {loading ? (
          <Skeleton variant="text" width={13} height={32} />
        ) : (
          <p>{product.price}</p>
        )}
      </div>
      <div className="text-black flex justify-between">
        <span className="font-bold">Description:</span>{" "}
        {loading ? (
          <Skeleton variant="text" width={263} height={32} />
        ) : (
          <p>{product.description}</p>
        )}
      </div>

      <Link to="/">
        <p className="mt-10 hover:underline">Back to Home</p>
      </Link>
    </div>
  );
}

export default Product;
