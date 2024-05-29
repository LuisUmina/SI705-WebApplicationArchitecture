class Cuadrado{
    private lado:number;

    constructor(la:number){
        this.lado = la;
    }

    public cacularPerimetro(){
        return this.lado*4;
    }
}

console.log("cuadrado01: ", new Cuadrado(5).cacularPerimetro())