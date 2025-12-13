import React, { useState } from "react";

function SearchComponents({ setTextAPI }) {
  const [text, setText] = useState("people");
  const [ID, setID] = useState(1);

  const handleSubmit = (e) => {
    e.preventDefault();
    setTextAPI(text + "/" + ID + "/");
  };

  return (
    <form
      action={"#"}
      onSubmit={handleSubmit}
      className="flex gap-3 w-full mx-auto text-xl items-center"
    >
      <div className="flex gap-2">
        <label htmlFor="">Search for:</label>
        <select
          name=""
          id=""
          value={text}
          onChange={(e) => setText(e.target.value)}
          className="border-2 border-black py-1"
        >
          <option value="people">People</option>
          <option value="planets">Planets</option>
        </select>
      </div>
      <div className="flex justify-evenly gap-2 w-fit">
        <label htmlFor="">ID:</label>
        <input
          value={ID}
          type="text"
          name=""
          id=""
          onChange={(e) => setID(e.target.value)}
          className="pl-2 py-1 border-2 border-black w-1/2"
        />
      </div>
      <button className="bg-blue-600 px-2 py-2 rounded-2xl text-xl ">
        Submit
      </button>
    </form>
  );
}

export default SearchComponents;
