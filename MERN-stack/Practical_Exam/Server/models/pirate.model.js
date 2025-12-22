const mongoose = require("mongoose");
const PirateSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: [true, "name is required"],
      minLength: [3, "name must be at between 3 and 30 characters long"],
      maxLength: [30, "name must be at between 3 and 30 characters long"],
    },
    img: {
      type: String,
      required: [true, "img is required"],
    },
    treasure: {
      type: Number,
      required: [true, "treasure is required"],
    },
    phrase: {
      type: String,
      required: [true, "phrase is required"],
      minLength: [5, "phrase must be at least 5 characters long"],
    },
    position: {
      type: String,
      required: [true, "position is required"],
      default: "Sailor",
      enum: ["Sailor", "Captain", "First Mate"],
    },
    pegLeg: {
      type: Boolean,
      default: false,
    },
    eyePatch: {
      type: Boolean,
      default: false,
    },
    hookHand: {
      type: Boolean,
      default: false,
    },
  },
  {
    timestamps: true,
  }
);
const Pirate = mongoose.model("Pirate", PirateSchema);
module.exports = Pirate;
