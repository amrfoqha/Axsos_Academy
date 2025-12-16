const mongoose = require("mongoose");
const UserSchema = new mongoose.Schema({
  name: {
    type: String,
  },
  age: {
    type: Number,
  },
});
module.exports = user = mongoose.model("User", UserSchema);
