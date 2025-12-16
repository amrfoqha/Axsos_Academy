const product = require("../models/product.model");

module.exports.getAllProducts = (req, res) => {
  product
    .find()
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};

module.exports.getProductById = (req, res) => {
  product
    .findById(req.params.id)
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};

module.exports.createProduct = (req, res) => {
  const { title, price, description } = req.body;
  console.log(title, price, description);
  product
    .create({ title, price, description })
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};

module.exports.updateProduct = (req, res) => {
  product
    .findByIdAndUpdate(req.params.id, req.body)
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};

module.exports.deleteProduct = (req, res) => {
  product
    .findByIdAndDelete(req.params.id)
    .then((data) => {
      res.json(data);
    })
    .catch((err) => {
      res.json(err);
    });
};
