function remove(el) {
  el.remove();
}
function togglinglogin(el) {
  el.style.height = "50%";
  if (el.innerText == "Login") {
    el.innerText = "Logout";
  } else el.innerText = "Login";
}
