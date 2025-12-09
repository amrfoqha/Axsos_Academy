import React, { useEffect, useState } from "react";

function Form() {
  const [firstname, setFirstName] = useState("");
  const [lastname, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [conPassword, setConPassword] = useState("");
  const [fnameError, setFnameError] = useState(false);
  const [lnameError, setLnameError] = useState(false);
  const [emailError, setEmailError] = useState(false);
  const [passwordError, setPasswordError] = useState(false);
  const [conPasswordError, setConPasswordError] = useState(false);

  const validateFName = (e) => {
    if (e.target.value.length < 2 && e.target.value.length != 0)
      setFnameError(true);
    else {
      setFnameError(false);
      setFirstName(e.target.value);
    }
  };
  const validateLName = (e) => {
    if (e.target.value.length < 2 && e.target.value.length != 0)
      setLnameError(true);
    else {
      setLnameError(false);
      setLastName(e.target.value);
    }
  };
  const validateEmail = (e) => {
    if (e.target.value.length < 5 && e.target.value.length != 0)
      setEmailError(true);
    else {
      setEmailError(false);
      setEmail(e.target.value);
    }
  };
  const validatePassword = (e) => {
    const value = e.target.value;
    setPassword(value);
    setPasswordError(value.length < 8 && value.length !== 0);
  };
  const validateConPassword = (e) => {
    const value = e.target.value;
    setConPassword(value);
    setConPasswordError(password !== value);
  };
  // useEffect(() => {
  //   setConPasswordError(password != conPassword && password.length != 0);
  // }, [conPassword, password]);

  return (
    <>
      <form action="#" className=" p-4 text-black w-full text-2xl">
        <div>
          <div className="flex justify-between">
            <label htmlFor="" className="mr-4">
              First Name
            </label>
            <input
              type="text"
              className="mb-5 border border-black"
              onChange={(e) => validateFName(e)}
            />
          </div>
          {fnameError && (
            <p className="text-sm text-start text-red-700">
              field must be at least 2 characters
            </p>
          )}
        </div>
        <div>
          <div className="flex justify-between">
            <label htmlFor="" className="mr-4">
              Last Name
            </label>
            <input
              type="text"
              className="mb-5 border border-black"
              onChange={(e) => validateLName(e)}
            />
          </div>
          {lnameError && (
            <p className="text-sm text-start text-red-700">
              field must be at least 2 characters
            </p>
          )}
        </div>
        <div>
          <div className="flex justify-between">
            <label htmlFor="" className="mr-4">
              Email
            </label>
            <input
              type="email"
              className="mb-5 border border-black"
              onChange={(e) => validateEmail(e)}
            />
          </div>
          {emailError && (
            <p className="text-sm text-start text-red-700">
              field must be at least 5 characters
            </p>
          )}
        </div>
        <div>
          <div className="flex justify-between">
            <label htmlFor="" className="mr-4">
              Password
            </label>
            <input
              type="password"
              className="mb-5 border border-black"
              onChange={(e) => validatePassword(e)}
            />
          </div>
          {passwordError && (
            <p className="text-sm text-start text-red-700">
              field must be at least 8 characters
            </p>
          )}
        </div>
        <div>
          <div className="flex justify-between">
            <label htmlFor="" className="mr-4">
              Confirm Password
            </label>
            <input
              type="password"
              className="mb-5 border border-black"
              onChange={(e) => validateConPassword(e)}
            />
          </div>
          {conPasswordError && (
            <p className="text-sm text-start text-red-700">
              Passwords Must Match
            </p>
          )}
        </div>

        <button className="mt-5">Submit</button>
      </form>
    </>
  );
}

export default Form;
