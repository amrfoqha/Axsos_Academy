function countup() {
  var el = document.querySelector("#num");
  count = parseInt(el.innerText, 10);
  el.innerText = count + 1;
}
