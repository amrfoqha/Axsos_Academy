import React, { useState } from "react";
import "../app.css";
function SearchBar({ setColor, color }) {
  const [text, setText] = useState("");
  const addColor = () => {
    setColor([...color, text]);
    setText("");
  };
  return (
    <>
      <label htmlFor="">Color</label>
      <input
        type="text"
        className="mx-5 border border-black"
        value={text}
        onChange={(e) => setText(e.target.value)}
      />
      <button onClick={() => addColor()}>Add</button>
      <div>
        <div>
          <label htmlFor="">Width: {width}</label>
          <input type="number" value={width} />
        </div>
        <div>
          <label htmlFor="">hieght : {Height}</label>
          <input type="number" value={width} />
        </div>
        w
      </div>
    </>
  );
}

export default SearchBar;
