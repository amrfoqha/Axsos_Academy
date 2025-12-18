import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const Authors = () => {
  const [authors, setAuthors] = useState([]);
  const Navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await axios.get("http://localhost:8000/api/authors");
        setAuthors(res.data);
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, []);

  const handleDelete = async (id) => {
    try {
      const res = await axios.delete("http://localhost:8000/api/authors" + id);
      setAuthors(res.data);
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div>
      <h1 className="text-7xl">Favorite authors</h1>
      <Link
        to={"/authors/new"}
        className="text-blue-700 underline hover:text-blue-400 text-2xl"
      >
        Add new Author
      </Link>
      <p className="text-3xl text-start mt-5 mb-2 ml-2 ">Authors:</p>

      <table className="border border-black w-full h-full  text-2xl border-spacing-0.5 border-separate">
        <thead className="w-full">
          <tr className="border border-black">
            <th className="border border-black">Author</th>
            <th className="border border-black">Actions available </th>
          </tr>
        </thead>
        <tbody>
          {authors.map((el) => (
            <tr key={el._id}>
              <td className="border border-black">{el.name}</td>
              <td className="flex justify-center gap-4  border border-black py-2">
                <button
                  onClick={() => {
                    Navigate(`/authors/update/${el._id}`);
                  }}
                  className="text-sm"
                >
                  Edit
                </button>

                <button
                  onClick={() => {
                    handleDelete(el._id);
                  }}
                  className="text-sm"
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Authors;
