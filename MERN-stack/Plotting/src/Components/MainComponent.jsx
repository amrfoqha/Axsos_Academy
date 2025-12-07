import React from "react";

function MainComponent(props) {
  return (
    <div className="bg-[#e06666] w-[70%] flex-col justify-between p-8">
      {props.children}
    </div>
  );
}

export default MainComponent;
