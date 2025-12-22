import React from "react";
import axios from "axios";

const Apipirates = ({ setPirates } = {}) => {
  const fetchPirates = async () => {
    try {
      const res = await axios.get("http://localhost:8000/api/pirates");
      setPirates(res.data);
    } catch (error) {
      console.log(error);
    }
  };
  const deletePirates = async (id) => {
    try {
      await axios.delete(`http://localhost:8000/api/pirates/${id}`);
    } catch (error) {
      console.log(error);
    }
  };
  const updatePirates = async (id, pirate) => {
    try {
      const res = await axios.patch(
        `http://localhost:8000/api/pirates/${id}`,
        pirate
      );
      return res;
    } catch (error) {
      console.log(error);
      throw error;
    }
  };
  const getPirates = async (id) => {
    try {
      const res = await axios.get(`http://localhost:8000/api/pirates/${id}`);

      return res.data;
    } catch (error) {
      console.log(error);
    }
  };
  const createPirates = async (pirate) => {
    try {
      const res = await axios.post("http://localhost:8000/api/pirates", pirate);
      return res;
    } catch (error) {
      console.log(error);
      throw error;
    }
  };
  return {
    fetchPirates,
    deletePirates,
    updatePirates,
    getPirates,
    createPirates,
  };
};

export default Apipirates;
