const express = require("express");
const app = express();
const port = 8000;
import { faker } from "@faker-js/faker";
const { faker } = require("@faker-js/faker");

export function createUser() {
  return {
    password: faker.internet.password(),
    email: faker.internet.email(),
    phoneNumber: faker.phone.number(),
    lastName: faker.person.lastName(),
    firstName: faker.person.firstName(),
    _id: faker.database.mongodbObjectId(),
  };
}

export const users = faker.helpers.multiple(createUser, {
  count: 5,
});

export function createCompany() {
  return {
    _id: faker.database.mongodbObjectId(),
    name: faker.company.name(),
    address: faker.location.address(),
    street: faker.location.street(),
    city: faker.location.city(),
    state: faker.location.state(),
    zipCode: faker.location.zipCode(),
    country: faker.location.country(),
  };
}

export const companies = faker.helpers.multiple(createCompany, {
  count: 5,
});

app.get("/users", (req, res) => {
  res.json(users);
});

app.get("/companies", (req, res) => {
  res.json(companies);
});

app.get("/api/users/new", (req, res) => {
  res.json(createUser());
});

app.get("/api/companies/new", (req, res) => {
  res.json(createCompany());
});

app.get("/api/user/company", (req, res) => {
  res.json({ user: createUser(), company: createCompany() });
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
