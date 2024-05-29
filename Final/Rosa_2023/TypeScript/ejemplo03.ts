interface Animal{
    ruido(): void
}

class Perro implements Animal{
    ruido(){
        console.log("Wow!");
    }
}

class Gato implements Animal{
    ruido(){
        console.log("Mau!");
    }
}

console.log("El perro hace: ", new Perro().ruido(), " - y el Gato hace: ", new Gato().ruido());