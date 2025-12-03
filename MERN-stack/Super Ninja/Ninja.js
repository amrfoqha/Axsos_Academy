class Ninja {
  constructor(name, health) {
    this.name = name;
    this.health = health;
    this.speed = 3;
    this.strength = 3;
  }
  sayHello() {
    console.log("The name of the ninja is: " + this.name);
  }
  showStats() {
    console.log(
      this.name + " " + this.strength + " " + this.speed + " " + this.health
    );
  }
  drinkSake() {
    this.health += 10;
  }
}
module.exports = { Ninja };
