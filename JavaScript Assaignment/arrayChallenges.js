// function alwaysHungry(arr) {
//   var flage = false;
//   for (var index = 0; index < arr.length; index++) {
//     if (arr[index] == "food") {
//       console.log("yummy ");
//       flage = true;
//     }
//   }
//   if (!flage) console.log("i'm hungry");
// }

// alwaysHungry([3.14, "food", "pie", true, "food"]);
// // this should console log "yummy", "yummy"
// alwaysHungry([4, 1, 5, 7, 2]);
// // this should console log "I'm hungry"

// function highPass(arr, cutoff) {
//   var filteredArr = [];
//   // your code here
//   var i = 0;
//   for (var index = 0; index < arr.length; index++) {
//     if (arr[index] > 5){ filteredArr[i] = arr[index];
//     i++;
//   }
// }
//   return filteredArr;
// }
// var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
// console.log(result); // we expect back [6, 8, 10, 9]

// function betterThanAverage(arr) {
//   var sum = 0;
//   // calculate the average
//   var count = 0;
//   // count how many values are greated than the average
//   for (var i = 0; i < arr.length; i++) {
//     sum += arr[i];
//   }
//   var avg = sum / arr.length;

//   for (var index = 0; index < arr.length; index++) {
//     if (arr[index] > avg) {
//       count++;
//     }
//   }
//   return count;
// }
// var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
// console.log(result); // we expect back 4

// function reverse(arr) {
//   // your code here
//   // // return arr.reverse();
//   var j = arr.length - 1;
//   var temp;
//   for (var i = 0; i < j; i++) {
//     temp = arr[i];
//     arr[i] = arr[j];
//     arr[j] = temp;

//     j--;
//   }
//   return arr;
// }

// var result = reverse(["a", "b", "c", "d", "e"]);
// console.log( result); // we expect back ["e", "d", "c", "b", "a"]

// function fibonacciArray(n) {
//   // the [0, 1] are the starting values of the array to calculate the rest from
//   var fibArr = [0, 1];
//   for (var i = 2; i < n; i++) {
//     fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
//   }
//   return fibArr;
// }

// var result = fibonacciArray(10);
// console.log(result); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
