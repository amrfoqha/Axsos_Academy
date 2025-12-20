const Player = require("../model/team.model");

module.exports.getAllPlayer = async (req, res) => {
  try {
    const players = await Player.find();
    res.json(players);
  } catch (error) {
    res.status(400).json(error);
  }
};
module.exports.createPlayer = async (req, res) => {
  console.log(req.body);
  try {
    const player = await Player.create(req.body);
    res.json(player);
  } catch (error) {
    res.status(400).json(error);
  }
};
module.exports.updatePlayer = async (req, res) => {
  const id = req.params.id;
  const { game, status } = req.body;

  try {
    const players = await Player.findByIdAndUpdate(
      id,
      {
        [`status.${game}`]: status,
      },
      { new: true }
    );
    res.json(players);
  } catch (error) {
    res.status(400).json(error);
  }
};
module.exports.deletePlayer = async (req, res) => {
  const id = req.params.id;
  console.log(id);

  try {
    const players = await Player.findByIdAndDelete(id);
    res.json({ msg: "delete success!" });
  } catch (error) {
    res.status(400).json(error);
  }
};
module.exports.getPlayer = async (req, res) => {
  const id = req.params.id;
  try {
    const player = await Player.findById(id);
    res.json(player);
  } catch (error) {
    res.status(400).json(error);
  }
};
