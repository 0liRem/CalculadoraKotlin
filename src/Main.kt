fun main() {
    calcu()
}
fun calcu(){
    println("Bienvenido a calculadora cientifica ingrese la operación a realizar")
    println("Suma +, resta -, multiplicación *, división /, potencia ^, parentesis (), raiz r, exponencial e")
    var operacion=readln()
    var arr = ArrayList<String>()
    for (i in operacion){
        arr.add(i.toString())
    }
    calculadora(arr)

    }