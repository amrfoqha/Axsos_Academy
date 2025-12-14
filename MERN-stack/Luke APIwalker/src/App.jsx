import { useState } from "react";
import "./App.css";
import SearchComponents from "./Components/SearchComponents";
import ResultComponent from "./Components/ResultComponent";

function App() {
  const [textAPI, setTextAPI] = useState("");
  const [result, setResult] = useState({});

  return (
    <>
      <SearchComponents setTextAPI={setTextAPI} />
      <ResultComponent
        result={result}
        textAPI={textAPI}
        setResult={setResult}
      />
    </>
  );
}

export default App;
