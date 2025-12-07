import { useState } from "react";
import React from "react";
import "./App.css";
import Header from "./Components/HeaderComponent";
import Navigation from "./Components/NavigationComponent";
import Main from "./Components/MainComponent";
import SubContents from "./Components/SubContentsComponent";
import Advertisement from "./Components/AdvertisementComponent";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="mt-5 bg-green-200 h-[600px] p-8">
      <Header />
      <div className="flex justify-between h-[70%] mt-8">
        <Navigation />
        <Main>
          <div className="flex justify-between h-3/4 pb-8">
            <SubContents />
            <SubContents />
            <SubContents />
          </div>
          <Advertisement />
        </Main>
      </div>
    </div>
  );
}

export default App;
