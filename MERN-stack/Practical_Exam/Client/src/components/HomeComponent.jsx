import React from "react";
import AddPiratesComponent from "./AddPiratesComponent";
import { Outlet } from "react-router-dom";
const HomeComponent = () => {
  return (
    <>
      <div className="w-full h-auto bg-[#ff9900]">
        <header className="bg-[#b45f06] h-28 text-[#4a3a2b] font-bold flex justify-end pr-18">
          <div className="flex items-center justify-between w-1/2 mr-14">
            <p className="text-4xl">Pirates crew</p>
            <AddPiratesComponent />
          </div>
        </header>
        <div className="flex flex-col h-[80%]">
          <Outlet />
        </div>
      </div>
    </>
  );
};

export default HomeComponent;
