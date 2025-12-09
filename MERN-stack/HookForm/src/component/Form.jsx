import React, { useState } from "react";

function Form() {
  const [firstname, setFirstName] = useState("");
  const [lastname, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [conPassword, setConPassword] = useState("");
  return (
    <>
      <form action="#" className=" p-4 bg-red-700 w-full text-2xl">
        <div className="flex justify-between">
          <label htmlFor="" className="mr-4">
            First Name
          </label>
          <input
            type="text"
            className="mb-5 border border-black"
            onChange={(e) => setFirstName(e.target.value)}
          />
        </div>
        <div className="flex justify-between">
          <label htmlFor="" className="mr-4">
            Last Name
          </label>
          <input
            type="text"
            className="mb-5 border border-black"
            onChange={(e) => setLastName(e.target.value)}
          />
        </div>
        <div className="flex justify-between">
          <label htmlFor="" className="mr-4">
            Email
          </label>
          <input
            type="email"
            className="mb-5 border border-black"
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <div className="flex justify-between">
          <label htmlFor="" className="mr-4">
            Password
          </label>
          <input
            type="password"
            className="mb-5 border border-black"
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <div className="flex justify-between">
          <label htmlFor="" className="mr-4">
            Confirm Password
          </label>
          <input
            type="password"
            className="mb-5 border border-black"
            onChange={(e) => setConPassword(e.target.value)}
          />
        </div>

        <button>Submit</button>
      </form>
      <div className=" p-4  bg-green-700 w-full text-2xl">
        <p>Your Data</p>
        <div className="flex justify-between px-10">
          <label htmlFor="">First Name:</label>
          <label htmlFor="" className="border border-black mt-2 p-1 w-1/2">
            {firstname}
          </label>
        </div>
        <div className="flex justify-between px-10">
          <label htmlFor="">Last Name:</label>
          <label htmlFor="" className="border border-black mt-2 p-1 w-1/2">
            {lastname}
          </label>
        </div>
        <div className="flex justify-between px-10">
          <label htmlFor="">Email:</label>
          <label htmlFor="" className="border border-black mt-2 p-1 w-1/2">
            {email}
          </label>
        </div>
        <div className="flex justify-between px-10">
          <label htmlFor="">Password:</label>
          <label htmlFor="" className="border border-black mt-2 p-1 w-1/2">
            {password}
          </label>
        </div>
        <div className="flex justify-between mt-2 px-10">
          <label htmlFor="">Confirm Password:</label>
          <label htmlFor="" className="border border-black p-1 w-1/2">
            {conPassword}
          </label>
        </div>
      </div>
    </>
  );
}

export default Form;
