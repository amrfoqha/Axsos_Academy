import { Card } from "./Card.js";

export class Unit extends Card {
  constructor(name, cost, power, resilience) {
    super(name, cost);
    this.power = power;
    this.resilience = resilience;
  }
  attack(target) {
    target.resilience -= this.power;
  }
}
