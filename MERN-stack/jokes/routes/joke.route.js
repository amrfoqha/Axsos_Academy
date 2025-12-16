const jokeController = require("../controllers/joke.controller");
module.exports = (app) => {
  app.get("/api/jokes", jokeController.getAllJokes);
  app.get("/api/jokes/:id", jokeController.getJokeById);
  app.post("/api/jokes", jokeController.createJoke);
  app.patch("/api/jokes/:id", jokeController.updateJoke);
  app.delete("/api/jokes/:id", jokeController.deleteJoke);
};
