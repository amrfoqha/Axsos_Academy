const company = {
  cName: "apple",
  colors: ["red", "green", "blue"],
  location: "california",
};

var { cName: firstname, colors } = company;

const sayHello = () => {
  console.log("hello");
};

sayHello();
