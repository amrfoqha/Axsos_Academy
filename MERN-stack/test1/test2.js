const batata = (newstr) => {
  var str = newstr.split("");
  let left = 0;
  let right = str.length - 1;
  while (left < right) {
    [str[left], str[right]] = [str[right], str[left]];
    left++;
    right--;
  }

  console.log(str.join(""));
};

batata("ayham");
