import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Apipirates from "../Functions/Apipirates";
import SeeCrewComponent from "./SeeCrewComponent";

const CreatePiratesForm = () => {
  const [name, setName] = useState("");
  const [img, setImg] = useState("");
  const [treasure, setTreasure] = useState("");
  const [phrase, setPhrase] = useState("");
  const [position, setPosition] = useState("Sailor");
  const [pegLeg, setPegLeg] = useState(false);
  const [eyePatch, setEyePatch] = useState(false);
  const [hookHand, setHookHand] = useState(false);
  const [errorName, setErrorName] = useState("");
  const [errorImg, setErrorImg] = useState("");
  const [errorTreasure, setErrorTreasure] = useState("");
  const [errorPhrase, setErrorPhrase] = useState("");
  const { createPirates } = Apipirates();

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await createPirates({
        name,
        img,
        treasure,
        phrase,
        position,
        pegLeg,
        eyePatch,
        hookHand,
      });

      console.log(res);
      navigate("/pirates");
    } catch (error) {
      console.log(error);
      setErrorName(error.response.data.errors.name.message);
      setErrorImg(error.response.data.errors.img.message);
      setErrorTreasure(error.response.data.errors.treasure.message);
      setErrorPhrase(error.response.data.errors.phrase.message);
    }
  };

  const validateName = (e) => {
    const value = e.target.value;
    setErrorName(
      value.length == 0
        ? "Name is required"
        : value.length < 3
        ? "Name must be at least 3 characters long"
        : value.length > 30
        ? "Name must be at most 30 characters long"
        : ""
    );
    setName(value);
  };

  const validateImg = (e) => {
    const value = e.target.value;
    setErrorImg(value.length == 0 ? "Image is required" : "");
    setImg(value);
  };

  const validateTreasure = (e) => {
    const value = e.target.value;
    setErrorTreasure(value.length == 0 ? "Treasure is required" : "");
    setTreasure(value);
  };

  const validatePhrase = (e) => {
    const value = e.target.value;
    setErrorPhrase(
      value.length == 0
        ? "Phrase is required"
        : value.length < 5
        ? "Phrase must be at least 5 characters long"
        : ""
    );
    setPhrase(value);
  };

  return (
    <div className="w-full h-screen bg-[#ff9900]">
      <header className="bg-[#b45f06] h-28 text-[#4a3a2b] font-bold flex justify-end pr-18">
        <div className="flex items-center justify-between w-1/2 mr-14">
          <p className="text-4xl">Pirates crew</p>
          <SeeCrewComponent />
        </div>
      </header>
      <form
        action=""
        className="flex justify-between w-[full] h-[70%] px-[20%]"
      >
        <div className="w-1/2  h-[600px] flex flex-col justify-between mt-10">
          <div className="flex flex-col gap-1 text-2xl">
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              name="name"
              id="name"
              value={name}
              onChange={validateName}
              className="bg-white border-2 border-black mt-2 w-1/2"
            />
            {errorName && <p className="text-white text-sm">{errorName}</p>}
          </div>
          <div className="flex flex-col gap-1 text-2xl">
            <label htmlFor="img">Image:</label>
            <input
              type="text"
              name="img"
              id="img"
              value={img}
              onChange={validateImg}
              className="bg-white border-2 border-black mt-2 w-1/2 text-sm h-9"
            />
            {errorImg && <p className="text-white text-sm">{errorImg}</p>}
          </div>
          <div className="flex flex-col gap-1 text-2xl">
            <label htmlFor="treasure">Treasure:</label>
            <input
              type="text"
              name="treasure"
              id="treasure"
              value={treasure}
              onChange={validateTreasure}
              className="bg-white border-2 border-black mt-2 w-1/2"
            />
            {errorTreasure && (
              <p className="text-white text-sm">{errorTreasure}</p>
            )}
          </div>
          <div className="flex flex-col gap-1 text-2xl">
            <label htmlFor="phrase">Phrase:</label>
            <input
              type="text"
              name="phrase"
              id="phrase"
              value={phrase}
              onChange={validatePhrase}
              className="bg-white border-2 border-black mt-2 w-1/2"
            />
            {errorPhrase && <p className="text-white text-sm">{errorPhrase}</p>}
          </div>
        </div>
        <div className="flex flex-col mt-10 text-2xl items-start justify-between">
          <div className="flex flex-col gap-1">
            <label htmlFor="position" className="mt-2 text-xl text-black">
              Crew Position:
            </label>
            <select
              name="position"
              id="position"
              onChange={(e) => setPosition(e.target.value)}
              className="bg-white border-2 border-black mt-2 text-md"
              defaultValue={"Sailor"}
            >
              <option value="Sailor">Sailor</option>
              <option value="Captain">Captain</option>
              <option value="First Mate">First Mate</option>
            </select>
          </div>
          <div className="flex flex-col gap-5 text-2xl">
            <div className="flex items-center ">
              <input
                type="checkbox"
                name="pegLeg"
                id="pegLeg"
                onChange={(e) => setPegLeg(e.target.checked)}
                className="mx-2 h-5 w-5"
              />
              <label htmlFor="pegLeg">Peg Leg</label>
            </div>
            <div className="flex items-center ">
              <input
                type="checkbox"
                name="eyePatch"
                id="eyePatch"
                onChange={(e) => setEyePatch(e.target.checked)}
                className="mx-2 h-5 w-5 "
              />
              <label htmlFor="eyePatch">Eye Patch</label>
            </div>
            <div className="flex items-center ">
              <input
                type="checkbox"
                name="hookHand"
                id="hookHand"
                onChange={(e) => setHookHand(e.target.checked)}
                className="mx-2 h-5 w-5 "
              />
              <label htmlFor="hookHand">Hook Hand</label>
            </div>
          </div>
          <button
            className=" text-black px-5 py-2 mt-5 border border-black bg-white"
            onClick={handleSubmit}
            style={{
              cursor:
                errorName || errorImg || errorTreasure || errorPhrase
                  ? "not-allowed"
                  : "pointer",
            }}
            disabled={errorName || errorImg || errorTreasure || errorPhrase}
          >
            Add Pirate
          </button>
        </div>
      </form>
    </div>
  );
};

export default CreatePiratesForm;
