import { Unit } from "./Unit.js";
import { Effect } from "./Effect.js";

const unit1 = new Unit("Red Belt Ninja", 3, 3, 4);
const effect1 = new Effect(
  "Hard Algorithm",
  2,
  "increase target's resilience by 3",
  "resilience",
  +3
);
effect1.play(unit1);
const unit2 = new Unit("Black Belt Ninja", 4, 5, 4);
const effect2 = new Effect(
  "Unhandled Promise Rejection",
  1,
  "reduce target's resilience by 2",
  "resilience",
  -2
);
effect2.play(unit1);
const effect3 = new Effect(
  "Pair Programming",
  3,
  "increase target's power by 2",
  "power",
  +2
);
effect3.play(unit2);
unit1.attack(unit2);
