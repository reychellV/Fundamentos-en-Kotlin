package com.reychellv.fundamentoskotlin.RetoV

import java.math.BigInteger
import kotlin.random.Random

class Nequi (usuario:String, contra:Int){
    //atributos
    val user:String
    val password:Int
    var money:Double=4500.0
    var moood:Boolean=false

    init {
        this.user = usuario
        this.password = contra
        println("Se creo un nuevo registro con el usuario $user y la contraseña **** \n la cuenta se inicializo con un saldo inicial de: $money")
    }
    fun nequiAccess(nombre: String, clave: Int): Boolean {
        var resp=false
        if (nombre == user && clave == password){
            resp = true
            moood=true
        }
        return resp
    }

    fun withdrawMoney():String{
        val random = Random(System.currentTimeMillis())
        val codeR:Int
        var response:String
        println("Para retirar escoja una opcion \n Cajero \n Punto fisio")
        val opcion:String= readLine()!!.toString()
        //validar que existan mas de 2000 pesos en la cuenta
        if (money < 2000.0){
            response = "No puedes retirar dinero, No te alcanza"s
        }else{
            println("Cuanto desea retirar: ")
            val retiro = readLine()!!.toDouble()
            if (retiro > money){
                response = "No puedes retirar $retiro porque solo tienes disponible $money"
            }else{
                codeR = random.nextInt(100_000, 999_999)
                money-=retiro
                response = "Para retirar $retiro en un $opcion hagalo con el código: $codeR \n Su saldo actual es de $money"
            }
        }
        return  response
    }

    fun sendMoney(monto:Double,telefono:BigInteger):String{
        val transaccion = if (monto > money){
            "No es posible enviar el dinero, el monto supera el dinero dispobible"
        }else{
            money-=monto
            "Se enviaron $monto al numero telefonico $telefono \n Su saldo actual es de: $money"
        }
        return transaccion
    }

    fun rechargeMoney(montoRecarga:Int):String{
        println("Esta seguro de cargar $montoRecarga pesos a su cuenta Nequi \n Responda Si o No")
        val confirma = readLine()!!.toString().lowercase()
        val retorno = when (confirma) {
            "si" -> {
                money+=montoRecarga
                "Recarga exitosa, su saldo actual es de $money"
            }
            "no" -> {
                "Proceso de recarga cancelado"
            }
            else -> {
                "response invalida, proceso de recarga cancelado"
            }
        }
        return retorno
    }

    fun logOut():String{
        moood=false
        return "Se ha cerrado la sesion"
    }
}

fun main() {
}