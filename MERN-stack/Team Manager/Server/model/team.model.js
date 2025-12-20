const mongoose = require("mongoose");
const { type } = require("os");
const teamSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      require: [true, "Name is require"],
      minlength: [2, "Player name must be at least 2 characters"],
    },
    position: {
      type: String,
      default: "",
    },
    status: {
      game1: { type: String, default: "Undecided" },
      game2: { type: String, default: "Undecided" },
      game3: { type: String, default: "Undecided" },
    },
  },
  { timestamps: true }
);
module.exports = team = mongoose.model("team", teamSchema);
