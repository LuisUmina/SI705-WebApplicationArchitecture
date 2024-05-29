var Cuadrado = /** @class */ (function () {
    function Cuadrado(la) {
        this.lado = la;
    }
    Cuadrado.prototype.cacularPerimetro = function () {
        return this.lado * 4;
    };
    return Cuadrado;
}());
console.log("cuadrado01: ", new Cuadrado(5).cacularPerimetro());
