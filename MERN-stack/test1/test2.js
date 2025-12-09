// const batata = (newstr) => {
//   var str = newstr.split("");
//   let left = 0;
//   let right = str.length - 1;
//   while (left < right) {
//     [str[left], str[right]] = [str[right], str[left]];
//     left++;
//     right--;
//   }

//   console.log(str.join(""));
// };

// batata("ayham");

const palindrome = (str) => {
  var arr = [];
  for (let ch of str) {
    arr.push(ch);
  }
  for (let index = 0; index < arr.length; index++) {
    if (str[index] != arr.pop()) {
      return false;
    }
  }
  return true;
};
console.log(palindrome("asasa"));
