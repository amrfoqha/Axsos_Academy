const { log } = require("console");

const pokémon = Object.freeze([
  {
    id: 1,
    name: "Bulbasaur",
    types: ["poison", "grass"],
  },
  {
    id: 5,
    name: "Charmeleon",
    types: ["fire"],
  },
  {
    id: 9,
    name: "Blastoise",
    types: ["water"],
  },
  {
    id: 12,
    name: "Butterfree",
    types: ["bug", "flying"],
  },
  {
    id: 16,
    name: "Pidgey",
    types: ["normal", "flying"],
  },
  {
    id: 23,
    name: "Ekans",
    types: ["poison"],
  },
  {
    id: 24,
    name: "Arbok",
    types: ["poison"],
  },
  {
    id: 25,
    name: "Pikachu",
    types: ["electric"],
  },
  {
    id: 37,
    name: "Vulpix",
    types: ["fire"],
  },
  {
    id: 52,
    name: "Meowth",
    types: ["normal"],
  },
  {
    id: 63,
    name: "Abra",
    types: ["psychic"],
  },
  {
    id: 67,
    name: "Machamp",
    types: ["fighting"],
  },
  {
    id: 72,
    name: "Tentacool",
    types: ["water", "poison"],
  },
  {
    id: 74,
    name: "Geodude",
    types: ["rock", "ground"],
  },
  {
    id: 87,
    name: "Dewgong",
    types: ["water", "ice"],
  },
  {
    id: 98,
    name: "Krabby",
    types: ["water"],
  },
  {
    id: 115,
    name: "Kangaskhan",
    types: ["normal"],
  },
  {
    id: 122,
    name: "Mr. Mime",
    types: ["psychic"],
  },
  {
    id: 133,
    name: "Eevee",
    types: ["normal"],
  },
  {
    id: 144,
    name: "Articuno",
    types: ["ice", "flying"],
  },
  {
    id: 145,
    name: "Zapdos",
    types: ["electric", "flying"],
  },
  {
    id: 146,
    name: "Moltres",
    types: ["fire", "flying"],
  },
  {
    id: 148,
    name: "Dragonair",
    types: ["dragon"],
  },
]);

const array1 = pokémon.filter((el) => el.id % 3 == 0);
console.log(array1);

const array2 = pokémon.filter((el) => el.types.includes("fire"));
console.log(array2);

const array3 = pokémon.filter((el) => el.types.length > 1);
console.log(array3);

const array4 = pokémon.map((el) => el.name);
console.log(array4);

const array5 = pokémon.filter((el) => el.id > 99).map((el) => el.name);
console.log(array5);

const array6 = pokémon
  .filter((el) => el.types == "poison")
  .map((el) => el.name);
console.log(array6);

const array7 = pokémon
  .filter((el) => el.types[1] === "flying")
  .map((el) => el.types[0]);
console.log(array7);

const array8 = pokémon.reduce(
  (count, el) => (el.types.includes("normal") ? count + 1 : count),
  0
);
console.log(array8);
