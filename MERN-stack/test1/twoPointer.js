const twoSum = (Array, target) => {
  var left = 0;
  var right = Array.length - 1;
  while (left < right) {
    if (Array[left] + Array[right] === target) {
      return [left, right];
    }
    if (Array[left] + Array[right] > target) {
      right--;
    } else {
      left++;
    }
    console.log(left, right);
  }
  return [];
};

console.log(twoSum([1, 3, 4, 7, 10, 13], 17));
