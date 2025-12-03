import { Card } from "./Card.js";
export class Effect extends Card {
  constructor(name, cost, text, state, magnitude) {
    super(name, cost);
    this.text = text;
    this.state = state;
    this.magnitude = magnitude;
  }

  play(target) {
    if (this.state == "resilience") {
      target.resilience += this.magnitude;
    }
    if (this.state == "power") {
      target.power += this.magnitude;
    }
  }
}
