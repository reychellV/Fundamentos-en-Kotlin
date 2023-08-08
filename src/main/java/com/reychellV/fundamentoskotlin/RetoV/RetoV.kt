package com.reychellv.fundamentoskotlin.RetoV
import com.reychellv.fundamentoskotlin.RetoV.Nequi

class RetoV {
}

fun main() {
    println("Bienvenido")
    val myUser = Nequi("josen",1234)
    var variableControl:Boolean=true
    //solicita datos necesarios
    println("Ingrese su nombre de usuario: ")
    val username= readLine()!!.toString()
    println("Ingrese una clave de 4 digitos: ")
    val passUser= readLine()!!.toInt()
    //valida que el inicio de sesion sea exitoso
    if (myUser.nequiAccess(username,passUser)){
        println("Bienvenido Nequi $username ")
        //ciclo de interaccion con la clase Nequi
        while (variableControl){
            println("Por favor elija una opcion: ")
            println("1. Recargar dinero a mi cuenta Nequi")
            println("2. Enviar dinero a numero telefonico")
            println("3. Retirar dinero de mi cuenta Nequi")
            println("4. Salir de Nequi")
            //se captura la opcion del usuario
            var opcion:Int = readLine()!!.toInt()
            //evalua la opcion del usuario y ejecuta un metodo de acuerdo con la opcion
            when(opcion){
                1-> {
                    println("Ingrese el monto que desea recargar: ")
                    val valorRecarga= readLine()!!.toInt()
                    println(myUser.rechargeMoney(valorRecarga))
                }
                2-> {
                    println("Ingrese el numero telefonico al cual le quiere enviar dinero: ")
                    val numTelefono= readLine()!!.toBigInteger()
                    println("Ingrese el monto de dinero que desea enviar: ")
                    val montoEnviar = readLine()!!.toDouble()
                    println(myUser.sendMoney(montoEnviar,numTelefono))
                }
                3-> {
                    println(myUser.withdrawMoney())
                }
                4->{
                    myUser.logOut()
                    variableControl=false
                }
                else-> println("Opcion incorrecta")
            }
        }
    }else{
        println("Usuario y/o contraseña incorrecta")
    }
}
