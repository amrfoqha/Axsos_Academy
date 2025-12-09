import { useState } from "react";

import "./App.css";
import SearchBar from "./component/searchBar";
import Divs from "./component/Divs";

function App() {
  const [color, setColor] = useState([]);

  return (
    <>
      <SearchBar setColor={setColor} color={color} />
      <div className="flex flex-wrap ">
        {color.map((item, i) => (
          <Divs key={i} color={item} />
        ))}
      </div>
    </>
  );
}

export default App;
