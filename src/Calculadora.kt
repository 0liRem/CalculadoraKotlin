fun calculadora(arr:ArrayList<String>){
    val regexnum = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    var bandera=true
    var arr2 = ArrayList<String>()
    var res=ArrayList<String>()
    for (i in arr){
        if (i=="("){
            bandera=false
        }
        if (i==")"){
            for(i in arr2){

            }
        }
        if (bandera){
            if (i.matches(regexnum)){
                println("b")
            }
            if (i=="+" || i=="-" || i=="*" || i=="/" || i=="r" || i=="e" || i=="^"){

            }
        }
        else{
            arr2.add(i)
        }
    }

}