import React, { useState } from "react";
import axios from "axios";

function AxsiosApiComponent() {
  const [pokemon, setPokemon] = useState([]);
  const fetchPokemon = () => {
    axios
      .get("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=1328")
      .then((res) => {
        console.log(res.data);
        setPokemon(res.data.results);
      });
  };

  return (
    <div>
      <button onClick={fetchPokemon}>Fetch Pokemon</button>
      <ul>
        {pokemon.map((pokemon) => (
          <li key={pokemon.name} className="text-md mt-5 list-decimal">
            {pokemon.name}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AxsiosApiComponent;
