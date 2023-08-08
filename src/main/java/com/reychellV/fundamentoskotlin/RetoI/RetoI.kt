package com.reychellv.fundamentoskotlin.RetoI

class RetoI {
}
/*Por lo general, el teléfono te proporciona un resumen de las notificaciones, escribe un programa
     que imprima el mensaje de resumen según la cantidad de notificaciones que recibiste.
     El programa debe permitir almacenar el mensaje y el conteo de mensajes que recibe cada teléfono.
     El mensaje debe incluir lo siguiente:

    •	La cantidad exacta de notificaciones cuando haya menos de 100
    •	99+ como cantidad de notificaciones cuando haya 100 o más.
    •	Y si no hay mensajes que aparezca que no existen mensajes disponibles
*/
fun main() {
    println("Bienvenido.")
    //contador de las notificaciones
    var contNot = 0
    //mensajes por defecto
    val mesDef = listOf<String>("First Message","Second Message","Thirth Message","Fourth Message","Fith Message")
    //mensajes que ve el usuario
    val userMessage = mutableListOf<String>()
    //valor al azar de posible cantidad de notificaciones
    val messageAmount = (1..900).random()

    //recibir mensajes y contar las notificaciones
    for (i in 1..messageAmount){
        var newMessage = mesDef.random()
        userMessage.add(newMessage)
        contNot++
    }

    //evaluar que mensaje se le mostrara al usuario
    when(contNot){
        in 1..99-> println("La cantidad de notificaciones recibidas es de un total de $contNot.")
        in 100..900-> println("La cantidad de notifiaciones recibidas es de +99")
        else-> println("No hay notificaciones.")
    }

    println(userMessage)
    print(contNot)
}