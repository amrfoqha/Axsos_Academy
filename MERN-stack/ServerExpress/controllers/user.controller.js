const User = require("../models/user.model");

module.exports.createUser = (req, res) => {
  const { name, age } = req.body;
  console.log(req.body);
  User.create({ name, age })
    .then((data) => {
      res.status(200).json({
        message: "User created successfully",
      });
    })
    .catch((err) => {
      res.json({
        message: "User not created",
      });
    });
};

module.exports.getAllUsers = (req, res) => {
  User.find()
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.status(500).json({
        message: "Users not found",
        error: err,
      });
    });
};

module.exports.getOneUser = (req, res) => {
  User.findById(req.params.id)
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.status(500).json({
        message: "User not found",
        error: err,
      });
    });
};

module.exports.deleteUser = (req, res) => {
  User.findByIdAndDelete(req.params.id)
    .then((data) => {
      res.json({ message: "User deleted successfully" });
    })
    .catch((err) => {
      res.json({
        message: "User not found",
      });
    });
};
