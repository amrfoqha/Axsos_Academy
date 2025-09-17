var old_color;
function ChangeColor(el) {
  old_color = el.style.backgroundColor;
  el.style.backgroundColor = "#3b4598";
}
function ReturnColor(el) {
  el.style.backgroundColor = old_color;
}
var info = { h1: "", span: "", Par: "", imgsrc: "", imgwidth: "" };
var clicked = false;
function ChangeContent(el) {
  if (!clicked) {
    info.h1 = document.querySelector(".second .content .text h1").innerText;
    info.Par = document.querySelector(".second .content .text p").innerText;
    info.imgsrc = document.querySelector(".second .content img").src;
    info.imgwidth = document.querySelector(".second .content img").style.width;
    info.imgheight = document.querySelector(
      ".second .content img"
    ).style.height;

    console.log(info);
    document.querySelector(".second .content .text h1").innerText =
      "what we do";
    document.querySelector(".second .content .text p").innerText =
      "At our company, innovation drives everything we do. We specialize in leveraging cutting-edge technologies and strategic expertise to empower businesses to grow smarter and faster. From enhancing digital experiences and optimizing internal workflows to unlocking new revenue opportunities";
    document.querySelector(".second .content img").src =
      "./icons-images/alt-features.png";
    document.querySelector(".second .content img").style.height = "87%";
    document.querySelector(".second .content img").style.width = "50%";
    // document.querySelector(".second .content .text p").style.fontSize = "110%";
    el.innerHTML = "Change Back";
    clicked = true;
  } else {
    document.querySelector(".second .content .text h1").innerText = info.h1;
    document.querySelector(".second .content .text p").innerText = info.Par;
    document.querySelector(".second .content img").src = info.imgsrc;
    document.querySelector(".second .content img").style.width = info.imgheight;
    document.querySelector(".second .content img").style.height = info.imgwidth;
    console.log(info);

    el.innerHTML = "Make A Change";
    clicked = false;
  }
}
var imges = [
  "./icons-images/values-1.png",
  "./icons-images/values-2.png",
  "./icons-images/values-3.png",
];
index = 0;
function AddCard() {
  if (index < 3) {
    var container = document.querySelector(".third .content");
    var newdiv = document.createElement("div");
    var newP = document.createElement("p");
    var newimg = document.createElement("img");
    newdiv.className = "card";
    newimg.src = imges[index];
    newimg.style.width = "75%";
    newP.innerText =
      " We provide modern, technology-driven solutions tailored to help you adapt, compete, and thrive in an ever-evolving market.";

    newdiv.appendChild(newimg);
    newdiv.appendChild(newP);
    container.appendChild(newdiv);
    index++;
  }
}

// var el = document.querySelector(".second");
// var previousScrollY = 0;

// el.addEventListener("scroll", function () {
//   const currentScrollY = el.scrollTop;
//   const scrollDifference = Math.abs(currentScrollY - previousScrollY);

//   if (scrollDifference > 170) {
//     var temp = document.querySelector(".first .bar");

//     temp.classList.remove("bar");
//     temp.classList.add("barnew");
//   }

//   previousScrollY = currentScrollY;
// });
