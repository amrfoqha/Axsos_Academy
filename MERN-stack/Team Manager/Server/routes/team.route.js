const teamController = require("../controller/team.controller");

module.exports = (app) => {
  app.get("/api/teams", teamController.getAllPlayer);
  app.post("/api/teams", teamController.createPlayer);
  app.patch("/api/teams/:id", teamController.updatePlayer);
  app.get("/api/teams/:id", teamController.getPlayer);
  app.delete("/api/teams/:id", teamController.deletePlayer);
};
