import React, { useState } from "react";

function Tags() {
  const [btn1, setBtn1] = useState(true);
  const [btn2, setBtn2] = useState(false);
  const [btn3, setBtn3] = useState(false);

  const ToggleEvent = (num) => {
    if (num === 1) {
      setBtn1(true);
      setBtn2(false);
      setBtn3(false);
    } else if (num === 2) {
      setBtn1(false);
      setBtn2(true);
      setBtn3(false);
    } else if (num === 3) {
      setBtn1(false);
      setBtn2(false);
      setBtn3(true);
    }
  };

  return (
    <>
      <div className={"flex text-2xl justify-between w-1/2 ml-[22%]"}>
        <button
          className={btn1 ? "bg-white text-red-500" : ""}
          onClick={() => ToggleEvent(1)}
        >
          Tab1
        </button>
        <button
          className={btn2 ? "bg-white text-red-500" : ""}
          onClick={() => ToggleEvent(2)}
        >
          Tab2
        </button>
        <button
          className={btn3 ? "bg-white text-red-500" : ""}
          onClick={() => ToggleEvent(3)}
        >
          Tab3
        </button>
      </div>
      <div className="mt-8 ml-[22%] w-1/2 h-[150px] border-2 border-black text-start p-2 text-xl">
        <div
          htmlFor=""
          className={"mx-auto w-full overflow-hidden resize-none"}
          disabled
        >
          <p className="text-xl">
            {btn1 && "Tab 1 Content is showing here."}
            {btn2 && "Tab 2 Content is showing here."}
            {btn3 && "Tab 3 Content is showing here."}
          </p>
        </div>
      </div>
    </>
  );
}

export default Tags;
