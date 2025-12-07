import React, { useState } from "react";
import "../App.css";

function PersonComponents({ firstName, lastName, age, hairColor }) {
  const [count, setCount] = useState(age);
  const ageUp = () => {
    setCount(count + 1);
  };
  return (
    <div className="w-1/4 mx-auto mt-18 text-center text-2xl">
      <h1 className="">
        {firstName.toUpperCase()}, {lastName.toUpperCase()}
      </h1>
      <h1 className="mt-5">Age: {count}</h1>
      <h1 className="mt-5">Hair Color: {hairColor}</h1>
      <button
        className="mt-5 border border-black px-1 py-1 rounded-md hover:bg-gray-200 hover:cursor-pointer"
        onClick={ageUp}
      >
        Birthday Button for {firstName} {lastName}
      </button>
    </div>
  );
}

export default PersonComponents;
