// Efecto al hacer scroll: cambia color de navbar
window.addEventListener("scroll", function() {
    let navbar = document.querySelector(".custom-navbar");
    if (window.scrollY > 50) {
        navbar.classList.add("scrolled");
    } else {
        navbar.classList.remove("scrolled");
    }
});