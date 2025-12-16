const mongoose = require("mongoose");
const jokeSchema = new mongoose.Schema({
  setup: {
    type: String,
    required: [true, "Setup is required"],
  },
  punchline: {
    type: String,
    required: [true, "Punchline is required"],
  },
});
module.exports = joke = mongoose.model("Joke", jokeSchema);
