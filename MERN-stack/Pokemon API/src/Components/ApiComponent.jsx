import React, { useState } from "react";

const ApiComponent = () => {
  const [pokemon, setPokemon] = useState([]);
  const fetchPokemon = async () => {
    const response = await fetch(
      "https://pokeapi.co/api/v2/pokemon/?offset=0&limit=1328"
    );
    const data = await response.json();
    console.log(data);
    setPokemon(data.results);
  };
  return (
    <div>
      <button onClick={() => fetchPokemon()}>Fetch Pokemon</button>
      <ul>
        {pokemon.map((pokemon) => (
          <li key={pokemon.name} className="text-md mt-5 list-decimal">
            {pokemon.name}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ApiComponent;
