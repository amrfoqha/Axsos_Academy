const Pirate = require("../models/pirate.model");

module.exports.findAllPirates = async (req, res) => {
  try {
    const pirates = await Pirate.find();
    res.json(pirates);
  } catch (err) {
    res.json(err);
  }
};

module.exports.getOnePirate = async (req, res) => {
  try {
    const pirate = await Pirate.findById({ _id: req.params.id });
    console.log(pirate);
    res.json(pirate);
  } catch (err) {
    res.status(500).json(err);
  }
};

module.exports.createPirate = async (req, res) => {
  try {
    const pirate = await Pirate.create(req.body);
    return res.json(pirate);
  } catch (err) {
    if (err.name === "ValidationError") {
      return res.status(400).json({ errors: err.errors });
    }
    return res.json(err);
  }
};

module.exports.updatePirate = async (req, res) => {
  try {
    const pirate = await Pirate.findByIdAndUpdate(req.params.id, req.body);
    res.json(pirate);
  } catch (err) {
    if (err.name === "ValidationError") {
      return res.status(400).json({ errors: err.errors });
    }
    return res.json(err);
  }
};

module.exports.deletePirate = async (req, res) => {
  try {
    const pirate = await Pirate.findByIdAndDelete(req.params.id);
    res.json({ msg: "deleted successfully" });
  } catch (err) {
    res.json(err);
  }
};
