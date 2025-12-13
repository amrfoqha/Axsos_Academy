const express = require("express");
const app = express();
const port = 8000;
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const users = [
  { firstName: "Reimu", lastName: "Hakurei", ID: "1" },
  { firstName: "Marisa", lastName: "Kirisame", ID: "2" },
  { firstName: "Sanae", lastName: "Kochiya", ID: "3" },
  { firstName: "Sakuya", lastName: "Izayoi", ID: "4" },
  { firstName: "Momiji", lastName: "Inubashiri", ID: "5" },
];

app.get("/api", (req, res) => {
  res.json({ message: "Hello World" });
});

app.get("/api/users", (req, res) => {
  res.json(users);
});
app.get("/api/users/:id", (req, res) => {
  const id = req.params.id;

  res.json(users.filter((el) => el.ID === id));
});

app.post("/api/users/new", (req, res) => {
  const { firstName, lastName } = req.body;
  if (!firstName || !lastName)
    return res.status(400).json({ error: "firstName and lastName required" });
  const ID = users[users.length - 1].ID + 1;
  const newUser = { firstName, lastName, ID };
  users.push(newUser);
  return res.status(201).json(newUser);
  return res.status(201).json({ firstName, lastName });
});

app.listen(port, () => console.log(`Listening on port ${port}`));
