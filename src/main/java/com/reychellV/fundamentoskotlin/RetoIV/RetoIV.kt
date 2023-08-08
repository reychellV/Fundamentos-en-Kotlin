package com.reychellv.fundamentoskotlin.RetoIV

class RetoIV {
}
/*Cree un programa que le permita realizar un menú de un restaurante, en el deben incluir los platos
organizados por Entradas, Platos Fuertes, desserts y drinks, a su vez cada plato de cada categoría debe tener un nombre, una descripción del plato y el precio.
El programa debe permitir agregar platos a cada categoría, mostrar todos os platos creados, mostrar los patos por
código, modificar el menú, modificar cada plato y eliminar un plato cuando ya no este dentro de menú.
*/
fun main() {
    println("Bienvenido")
    val entree = mutableListOf<String>("Arepa dulce","buñuelos","pizza mini","patacones")
    val fPlate = mutableListOf<String>("Sobrebarriga en sasdlsa","Patas de pollo fritas","Chiguiro","Langosta")
    val desserts = mutableListOf<String>("Gelatina mosaico","Cheesecake","Brownie","Fruta con helado")
    val drinks = mutableListOf<String>("Cerveza","Gaseosa","Agua","Jugo")
    val menu = mutableListOf<List<String>>(entree,fPlate,desserts,drinks )
    var variableControl = false

    //metodos
    fun showPlates(){
        for (i in 0 until menu.size){
            when(i){
                0-> println("Entradas")
                1-> println("Platos fuertes")
                2-> println("Postres")
                3-> println("Bebidas")
            }
            for (j in 0 until menu[i].size){
                print(menu[i][j]+"\n")
            }
            println()
        }
    }

    fun showForCode(cate:Int,plateCod:Int):String {
        var resp = if (plateCod < menu[cate].size) {
            "El plato de la categoria $cate con el codigo $plateCod es: ${menu[cate][plateCod]}"
        } else {
            "El codigo que usted ingreso no corresponde ningun plato de la categoria $cate"
        }
        return resp
    }

    fun addCategoryPlate(cate:Int,plato:String):String{
        when(cate){
            0-> entree.add(plato)
            1-> fPlate.add(plato)
            2-> desserts.add(plato)
            3-> drinks.add(plato)
        }
        return "Se agrego $plato a la categoria: $cate"
    }

    fun modifyPlate(cate:Int,plateCod:Int):String {
        var resp = if (plateCod < menu[cate].size) {
            var modifiedPlate:String=""
            println("Ingrese el valor con que desea modificar el plato $plateCod")
            var valor:String = readLine()!!.toString()
            when(cate){
                0-> {modifiedPlate = entree[plateCod]
                    entree[plateCod] = valor}
                1-> {modifiedPlate = fPlate[plateCod]
                    fPlate[plateCod] = valor}
                2-> {modifiedPlate = desserts[plateCod]
                    desserts[plateCod] = valor}
                3-> {modifiedPlate = drinks[plateCod]
                    drinks[plateCod] = valor}
            }
            "El plato: $modifiedPlate fue cambiado por $valor"
        } else {
            "El codigo que usted ingreso no corresponde ningun plato de la categoria $cate"
        }
        return resp
    }

    fun deletePlate(cate:Int,plato:String):String{
        var confirmation = ""
        when(cate){
            0-> {
                confirmation = if (entree.remove(plato)){
                    "Se elimino $plato de la categoria: $cate"
                }else{
                    "El plato $plato no se pudo eliminar porque no existe"
                }
            }
            1-> {
                confirmation = if(fPlate.remove(plato)){
                    "Se elimino $plato de la categoria: $cate"
                }else{
                    "El plato $plato no se pudo eliminar porque no existe"
                }
            }
            2-> {
                confirmation = if(desserts.remove(plato)){
                    "Se elimino $plato de la categoria: $cate"
                }else{
                    "El plato $plato no se pudo eliminar porque no existe"
                }
            }
            3-> {
                confirmation = if(drinks.remove(plato)){
                    "Se elimino $plato de la categoria: $cate"
                }else{
                    "El plato $plato no se pudo eliminar porque no existe"
                }
            }
        }
        return confirmation
    }

    while (!variableControl){
        println("Bienvenido al sistema del restaurante, por favor elija una opcion: ")
        println("1. Mostrar todos los platos del menu.")
        println("2. Mostrar platos por código.")
        println("3. Agregar un plato a una categoria.")
        println("4. Modificar un plato.")
        println("5. Eliminar un plato.")
        println("6. salir")

        var opcion:Int = readLine()!!.toInt()

        when(opcion) {
            1 -> showPlates()
            2 -> {

                println("Elija por favor una categoria \n 0. Entradas \n 1. Platos Fuertes \n 2. desserts \n 3. drinks")
                var opcion:Int= readLine()!!.toInt()
                if (opcion !in 0..3){
                    println("Opcion incorrecta")
                }else {
                    //llama el metodo correspondiente
                    println("Ingrese el codigo del plato que desea buscar: ")
                    var codigo: Int = readLine()!!.toInt()
                    println( showForCode(opcion, codigo))
                }
            }
            3 -> {
                println("Elija por favor una categoria \n 0. Entradas \n 1. Platos Fuertes \n 2. desserts \n 3. drinks")
                var opcion:Int= readLine()!!.toInt()
                if (opcion !in 0..3){
                    println("Opcion incorrecta")
                }else {
                    println("Ingrese el plato que desea agregar: ")
                    var newPlate:String = readLine()!!.toString()
                    println( addCategoryPlate(opcion, newPlate))
                }

            }
            4 -> {
                println("Elija por favor una categoria \n 0. Entradas \n 1. Platos Fuertes \n 2. desserts \n 3. drinks")
                var opcion:Int= readLine()!!.toInt()
                if (opcion !in 0..3){
                    println("Opcion incorrecta")
                }else {
                    println("Ingrese el codigo del plato que desea modificar: ")
                    var codigo: Int = readLine()!!.toInt()
                    println( modifyPlate(opcion, codigo))
                }
            }
            5 -> {
                println("Elija por favor una categoria \n 0. Entradas \n 1. Platos Fuertes \n 2. desserts \n 3. drinks")
                var opcion:Int= readLine()!!.toInt()
                if (opcion !in 0..3){
                    println("Opcion incorrecta")
                }else {
                    println("Ingrese el plato que desea eliminar: ")
                    var deletePlate:String = readLine()!!.toString()
                    println( deletePlate(opcion, deletePlate))
                }
            }
            6 -> variableControl=true
            else -> println("Opcion del menu incorrecta, intente de nuevo")
        }
    }
    println("Hasta luego.")


}