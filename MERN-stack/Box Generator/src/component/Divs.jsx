import React from "react";
import "../app.css";
function Divs({ color }) {
  return (
    <div
      style={{ backgroundColor: color }}
      className="w-[250px] h-[250px] ml-10 mt-10"
    ></div>
  );
}

export default Divs;
