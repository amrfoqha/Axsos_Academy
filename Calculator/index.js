var mem = 0;
var exp = { num: "", op: "+" };

function press(el) {
  exp.num = exp.num + el;
  var x = document.querySelector("#display");
  x.innerText = exp.num;
}

function setOP(el) {
  exp.op = el;
  mem = parseFloat(exp.num);
  exp.num = 0;
  console.log(exp.num);
  var x = document.querySelector("#display");
  x.innerText = mem;
}
function calculate() {
  if (exp.op == "+") {
    var x = document.querySelector("#display");
    x.innerText = mem + parseFloat(exp.num);
  }
  if (exp.op == "-") {
    var x = document.querySelector("#display");
    x.innerText = mem - parseFloat(exp.num);
  }
  if (exp.op == "*") {
    var x = document.querySelector("#display");
    x.innerText = mem * parseFloat(exp.num);
  }
  if (exp.op == "/") {
    var x = document.querySelector("#display");
    x.innerText = mem / parseFloat(exp.num);
  }
}

function clr() {
  var x = document.querySelector("#display");
  x.innerText = 0;
  mem = 0;
  exp.num = "";
  exp.op = "";
}
