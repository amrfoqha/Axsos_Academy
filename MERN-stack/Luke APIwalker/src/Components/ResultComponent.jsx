import React, { useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function ResultComponent({ result, textAPI, setResult }) {
  const flag = textAPI.includes("people");

  useEffect(() => {
    axios.get("https://swapi.dev/api/" + textAPI).then((res) => {
      setResult(res.data);
      console.log(res.data);
    });
  }, [textAPI, setResult]);
  return (
    <div>
      {result.name &&
        (flag ? (
          <ul className="flex-col justify-between mt-10 text-xl">
            <li className="text-4xl mt-5">
              Name: <span className="text-blue-600 ml-2">{result.name}</span>
            </li>
            <li className="mt-2">
              Height:
              <span className="text-blue-600 ml-2">{result.height}</span>
            </li>
            <li className="mt-2">
              Hair Color:
              <span className="text-blue-600 ml-2">{result.hair_color}</span>
            </li>
            <li className="mt-2">
              Skin Color:
              <span className="text-blue-600 ml-2">{result.skin_color}</span>
            </li>
            <li className="mt-2">
              Homeworld:
              <Link
                to={result.homeworld}
                className="text-blue-600 underline ml-2"
              >
                Homeworld
              </Link>
            </li>
          </ul>
        ) : (
          <ul className="flex-col justify-between mt-10 text-xl">
            <li className="text-4xl mt-5">
              Name: <span className="text-blue-600 ml-2">{result.name}</span>
            </li>
            <li className="mt-2">
              Climate:
              <span className="text-blue-600 ml-2">{result.climate}</span>
            </li>
            <li className="mt-2">
              Terrain:
              <span className="text-blue-600 ml-2">{result.terrain}</span>
            </li>
            <li className="mt-2">
              Surface Water:
              <span className="text-blue-600 ml-2">{result.surface_water}</span>
            </li>
            <li className="mt-2">
              Population:
              <span className="text-blue-600 ml-2">{result.population}</span>
            </li>
          </ul>
        ))}
    </div>
  );
}

export default ResultComponent;
