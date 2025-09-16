function alt() {
  alert("Loading Weather Report");
}

function remv() {
  document.querySelector(".cookie").remove();
}

function convert(el) {
  var maxs = document.querySelectorAll(".max");
  var mins = document.querySelectorAll(".min");

  for (let i = 0; i < maxs.length; i++) {
    var max = parseInt(maxs[i].innerText, 10);
    var min = parseInt(mins[i].innerText, 10);
    if (el.value == "f") {
      maxs[i].innerText = Math.round(max * 1.8 + 32);
      mins[i].innerText = Math.round(min * 1.8 + 32);
    } else {
      maxs[i].innerText = Math.floor((max - 32) / 1.8);
      mins[i].innerText = Math.floor((min - 32) / 1.8);
    }
  }
}
