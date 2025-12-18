const Author = require("../models/Author.model");

module.exports.getAllAuthors = async (req, res) => {
  try {
    const authors = await Author.find();
    res.json(authors);
  } catch (error) {
    res.json(error);
  }
};
module.exports.createAuthor = async (req, res) => {
  const data = req.body;

  try {
    const author = await Author.create(data);
    res.status(201).json(author);
  } catch (error) {
    res.status(400).json(error);
  }
};
module.exports.editAuthor = async (req, res) => {
  try {
    const author = await Author.findByIdAndUpdate(req.params.id, req.body);
    res.json(author);
  } catch (error) {
    res.json(Json.Stringfy(error));
  }
};
module.exports.deleteAuthor = async (req, res) => {
  try {
    await Author.findByIdAndDelete(req.params.id);
    res.json({ msg: "delete success!" });
  } catch (error) {
    res.json(error);
  }
};
module.exports.getAuthor = async (req, res) => {
  try {
    const author = await Author.findById(req.params.id);
    res.json(author);
  } catch (error) {
    res.json(error);
  }
};
