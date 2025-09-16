function pizzaOven(size, crust, bread, sauce, cheeses, toppings) {
  var pizza = {
    size: size,
    crust: crust,
    bread: bread,
    sauce: sauce,
    cheeses: cheeses,
    toppings: toppings,
  };
  return pizza;
}

var p1 = pizzaOven("large", "thin", "wheat", "tomato", "mozzarella", [
  "alfredo",
  "pepperoni",
  "chicken",
]);
var p2 = pizzaOven(
  "medium",
  "deep dish",
  "wheat",
  "traditional",
  "mozzarella",
  ["pepperoni", "sausage"]
);
var p3 = pizzaOven(
  "small",
  "hand tossed",
  "wheat",
  "marinara",
  ["mozzarella", "feta"],
  ["mushrooms", "olives", "onions"]
);
var p4 = pizzaOven("xlarge", "thick", "corn", "alfredo", "Parmesan", [
  "olives",
  "tomato",
]);

function randnum() {
  return Math.floor(Math.random() * 5);
}

function randompizza(params) {
  var sizes = ["small", "medium", "large", "x-large", "xx-large"];
  var crusts = ["thin", "hand-tossed", "pan", "deep dish", "thick"];
  var breads = ["white", "wheat", "corn", "multigrain", "Bran"];
  var sauces = ["marinara", "tomato", "BBQ", "alfredo", "pesto"];
  var cheeseOptions = [
    "mozzarella",
    "cheddar",
    "parmesan",
    "feta",
    "no cheese",
  ];
  var topping = ["pepperoni", "chicken", "mushroom", "onion", "extra cheese"];

  return pizzaOven(
    sizes[randnum()],
    crusts[randnum()],
    breads[randnum()],
    sauces[randnum()],
    cheeseOptions[randnum()],
    topping[randnum()]
  );
}

console.log(randompizza());
console.log(randompizza());
console.log(randompizza());
