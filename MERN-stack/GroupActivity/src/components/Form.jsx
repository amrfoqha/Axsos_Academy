import React, { useEffect, useState } from "react";
import axios from "axios";

function Form() {
  const [isSubmit, setIsSbmit] = useState(false);
  const [result, setResult] = useState([]);
  const toggleState = () => {
    setIsSbmit(!isSubmit);
  };

  useEffect(() => {
    if (isSubmit) {
      axios.get("https://jsonplaceholder.typicode.com/users").then((res) => {
        setResult(res.data);
      });
    } else {
      setResult([]);
    }
  }, [isSubmit]);
  return (
    <div>
      <form action="#" onSubmit={() => toggleState()}>
        <label htmlFor="name" className="block m-2">
          Name
        </label>
        <input type="text" id="name" className="border border-black" />
        <br />

        <label htmlFor="password" className="block m-2">
          Password
        </label>
        <input type="password" id="password" className="border border-black" />
        <br />
        <button type="submit" className="bg-black text-white p-2 m-2">
          Submit
        </button>
      </form>
      <ol className="flex flex-col gap-2 items-start">
        {result?.map((el, index) => {
          return (
            <li key={index} className="m-2 list-decimal">
              {el.username}
            </li>
          );
        })}
      </ol>
    </div>
  );
}

export default Form;
