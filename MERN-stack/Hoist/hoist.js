//1
console.log(example);
var example = "world";
//output: undefined

//2
var needle = "heystack";
test();
function test() {
  console.log(needle);
}
//output: heystack

//3
var brendan = "super cool";
function print() {
  brendan = "only okay";
  console.log(brendan);
}
console.log(brendan);
//output: super cool

//4
var food = "chicken";
console.log(food);
eat();
function eat() {
  food = "half-chicken";
  console.log(food);
  var food = "gone";
}
//output: half-chicken

//5
mean();
console.log(food);

var mean = function () {
  food = "chicken";
  console.log(food);
  var food = "fish";
  console.log(food);
};

console.log(food);
//output: Error

//6
console.log(gener);
var gener = "disco";
rewind();
function rewind() {
  genre = "rock";
  console.log(genre);
  var genre = "r&b";
  console.log(genre);
}
console.log(genre);
//output: undefined,rock,r&b,Error

//7
dojo = "san jose";
console.log(dojo);
learn();
function learn() {
  dojo = "seattle";
  console.log(dojo);
  var dojo = "burbank";
  console.log(dojo);
}
console.log(dojo);
//output: san jose,seattle,burbank,san jose

//8
console.log(makeDojo("Chicago", 65));
console.log(makeDojo("Berkeley", 0));
function makeDojo(name, students) {
  const dojo = {};
  dojo.name = name;
  dojo.students = students;
  if (dojo.students > 50) {
    dojo.hiring = true;
  } else if (dojo.students <= 0) {
    dojo = "closed for now";
  }
  return dojo;
}
//output : name:Chicago,students:65,hiring:true,Error
