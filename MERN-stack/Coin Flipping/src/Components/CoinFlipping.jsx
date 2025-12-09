import React from "react";

function tossCoin() {
  return Math.random() > 0.5 ? "heads" : "tails";
}

function CoinFlipping() {
  function fiveHeads() {
    return new Promise((resolve, reject) => {
      var tring = 0;
      var headCounter = 0;
      while (headCounter < 5) {
        var temp = tossCoin();
        tring++;
        if (temp == "heads") {
          headCounter++;
        } else {
          headCounter = 0;
        }

        if (tring === 10000) {
          reject("alots of tries was made");
          return;
        }
      }
      resolve(`It took ${tring} tries to flip five "heads"`);
    });
  }
  fiveHeads()
    .then((res) => console.log(res))
    .catch((err) => console.log(err));
  console.log("When does this run now?");

  return <div>CoinFlipping</div>;
}

export { CoinFlipping };
