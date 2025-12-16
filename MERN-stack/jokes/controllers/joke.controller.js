const joke = require("../models/joke.model");

module.exports.getAllJokes = (req, res) => {
  joke
    .find()
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};

module.exports.getJokeById = (req, res) => {
  joke
    .findById(req.params.id)
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};

module.exports.createJoke = (req, res) => {
  joke
    .create(req.body)
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};

module.exports.updateJoke = (req, res) => {
  joke
    .findByIdAndUpdate(req.params.id, req.body)
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};

module.exports.deleteJoke = (req, res) => {
  joke
    .findByIdAndDelete(req.params.id)
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};
