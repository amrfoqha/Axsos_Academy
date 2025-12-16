const UserController = require("../controllers/user.controller");

module.exports = (app) => {
  app.post("/api/user/new", UserController.createUser);
  app.get("/api/users", UserController.getAllUsers);
  app.get("/api/user/:id", UserController.getOneUser);
  app.delete("/api/user/:id", UserController.deleteUser);
};
