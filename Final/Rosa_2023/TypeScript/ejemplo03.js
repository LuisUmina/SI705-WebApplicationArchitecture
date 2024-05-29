var Perro = /** @class */ (function () {
    function Perro() {
    }
    Perro.prototype.ruido = function () {
        console.log("Wow!");
    };
    return Perro;
}());
var Gato = /** @class */ (function () {
    function Gato() {
    }
    Gato.prototype.ruido = function () {
        console.log("Mau!");
    };
    return Gato;
}());
console.log("El perro hace: ", new Perro().ruido(), " - y el Gato hace: ", new Gato().ruido());
