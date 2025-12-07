import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import PersonComponents from "./Components/PersonComponents";

function App() {
  return (
    <>
      <PersonComponents
        firstName="amr"
        lastName="foqha"
        hairColor="black"
        age={24}
      />
      <PersonComponents
        firstName="yousf"
        lastName="ahmad"
        hairColor="brown"
        age={19}
      />
      <PersonComponents
        firstName="ameer"
        lastName="foqha"
        hairColor="red"
        age={44}
      />
    </>
  );
}

export default App;
