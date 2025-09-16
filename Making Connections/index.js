function change_name() {
  document.querySelector("#name").innerHTML = "Adrien D";
}
function decline(el) {
  var parent = el.closest(".details");
  parent.remove();
  var count = document.querySelector("#reqnum").innerText;
  count = parseInt(count, 10);
  document.querySelector("#reqnum").innerText = count - 1;
}
function accept(el) {
  var parent = el.closest(".details");
  parent.remove();
  var element = document.querySelector(".Your-Connections .header h1");
  var count = element.innerText;
  count = parseInt(count, 10);
  element.innerText = count + 1;

  var count1 = document.querySelector("#reqnum").innerText;
  count1 = parseInt(count1, 10);
  document.querySelector("#reqnum").innerText = count1 - 1;
}
