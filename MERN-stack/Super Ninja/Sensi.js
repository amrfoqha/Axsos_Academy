const { Ninja } = require("../Super Ninja/Ninja");

class Sensi extends Ninja {
  constructor(name, health) {
    super(name, health);
    this.wisdom = 10;
  }
  speakWisdom() {
    super.drinkSake();
    console.log(
      "What one programmer can do in one month, two programmers can do in two months."
    );
  }
}

const s1 = new Sensi("kakashi", 100);
s1.speakWisdom();
