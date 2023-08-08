package com.reychellv.fundamentoskotlin.RetoIII

class RetoIII {
}
/*Por lo general, en una subasta, el ofertante que ofrece el importe más alto determina el precio

     * de un artículo. En esta subasta especial, si nadie oferta por un artículo, este se vende automáticamente a la
     * casa de subastas al precio mínimo. Cree un programa que permita simular una subasta y pueda tener el precio base
     * y cada uno de los precios ofertados y comparar cada uno de los precios y venderlo al ofertante con el precio mas
     * elevado. A su vez si no hay ofertas dejar el articulo para la casa, el sistema debe ofertar varios articulo que
     * usted determinara, así como recibir varias ofertas.*/

fun main() {
    println("Bienvenido.")

    val products = mutableListOf<String>("Moto de Elvis Presley","Corona de la Reina Isabel II","Una rubia","Guitarras de Bon Jovi","La casa de la profeSdss")
    var soldProduct:Boolean=false
    var emptyLists:Boolean=false
    var productIterations:Int=0

    //mientras que la lista no este vacia subaste los productos que alli se encuentran
    while (!emptyLists){
        //genere un precio base para el producto, seleccione un producto y inicialice las oferta max en 0
        val productPrice:Int= (1..10).random()
        var product:String = products.random()
        var ofertaMax:Int=0
        //dele un valor a la iteracion del producto
        productIterations++
        //capture la cantidad de participants por iteracion de oferta e informe precio base y nombre del producto a subastar
        println("Cuantos ofertantes participaran en la subasta numero $productIterations")
        var participants:Int = readLine()!!.toInt()
        println("El producto a ofertar es: $product y su precio base es:$productPrice")
        //mientras que el producto no este vendido y los participants sean mayor que 0
        while (!soldProduct && participants >0){
            //ciclo para reunir las ofertas de los participants
                for (i in 1..participants){
                    //pregunta si quiere ofertar
                    println("Usuario $i ¿quiere ofertar algun valor?: Responda si o no")
                    var rta:String = readLine()!!.toString().lowercase()
                    //si es una afirmacion pregunta el valor de la oferta
                    if (rta.equals("si")){
                        print("Cuanto quiere ofertar: ")
                        var usuarioOferta:Int= readLine()!!.toInt()
                        //evalua si el valor de la oferta es mayor a la oferta maxima y si cumple reasigna su valor
                        if (usuarioOferta > ofertaMax){
                            ofertaMax=usuarioOferta
                        }
                        //si no quiere ofertar elimina el participante e informa la salida de la subasta
                    }else{
                        participants--
                        println("El usuario $i ha salido de la subasta ")
                    }
                    //si los partipantes es igual a uno rompe el ciclo for
                    if (participants == 1){
                        break
                    }
                }

            //evalua como se vendio el producto si por valor maximo o por ofertas nulas
            if ((participants==1 && ofertaMax >0) || (ofertaMax > 0 && participants == 0) ){
                //si el producto fue vendido por valor maximo informa por cuanto se vendio, elimina el producto de la lista y coloca la varaible de control en true
                println("El producto $product se vendio por $ofertaMax")
                products.remove(product)
                soldProduct = true
            }else if( participants == 0){
                //si vendio por ofertas nulas solo elimina el producto de la lista
                println("El producto $product se vendio a la casa por el precio minimo")
                products.remove(product)
            }
        }
        //reasigna el producto vendido en false para que no quede en bucle infinito
        soldProduct=false
        //si la lista ya no tiene productos para ofertar coloca la variable de control en true para que salga de la subasta
        if (products.isEmpty()){
            emptyLists=true
        }
    }
    //informa que el programa termino
    println("LA SUBASTA HA TERMINADO")

}