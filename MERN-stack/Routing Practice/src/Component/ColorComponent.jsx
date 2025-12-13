import React from "react";
import { useParams } from "react-router-dom";

function ColorComponent() {
  const { param, color1, color2 } = useParams();
  const isNumber = isNaN(param) ? false : true;
  const number = isNumber ? Number(param) : null;
  const word = isNumber ? null : param;

  return (
    <>
      {word != null && (
        <h1 style={{ color: color1, backgroundColor: color2 }}>
          the word is : {word}
        </h1>
      )}
      {number != null && (
        <h1 style={{ color: color1, backgroundColor: color2 }}>
          the number is : {number}
        </h1>
      )}
    </>
  );
}

export default ColorComponent;
