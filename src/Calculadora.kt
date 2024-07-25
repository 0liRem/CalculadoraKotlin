fun calculadora(arr:ArrayList<String>){
    val regexnum = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    var bandera=true
    for (i in arr){
        if (i=="("){
            bandera=false
        }
        if (bandera){
            if (i.matches(regexnum)){
                println("b")
            }
        }
    }

}