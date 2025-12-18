const authorController = require("../controllers/Author.controller");
module.exports = (app) => {
  app.get("/api/authors", authorController.getAllAuthors);
  app.get("/api/authors/:id", authorController.getAuthor);
  app.delete("/api/authors/:id", authorController.deleteAuthor);
  app.put("/api/authors/:id", authorController.editAuthor);
  app.post("/api/authors", authorController.createAuthor);
};
