package com.reychellv.fundamentoskotlin.RetoII

import com.reychellv.fundamentoskotlin.RetoII.Album

class RetoII {
}
/*Imagina que necesitas crear una app de reproducción de música. Crea una clase que pueda representar
    la estructura de varias canciones de un álbum. La clase Álbum debe incluir estos elementos de código:

        •	Preguntar cuantas canciones tiene este álbum
        •	Tipo de música del Album
        •	Para cada canción el título, el artista, el año de publicación y el recuento de reproducciones
        •	Mostrar la cant de reproducciones y evaluar cual es la la canción mas popular del álbum
        •	 Mostrar la cant de reproducciones y evaluar las canciones como mas popular  o poco pupular del
            álbum(si el recuento de reproducciones es inferior a 1,000, considera que es poco popular)
        •	Un método para imprimir todas las descripciones de las canción  que pertenezcan a un albúm en este formato:
            "[Título], interpretada por [artista], se lanzó en [año de lanzamiento]", cant de reproducciones.
*/
fun main() {
    println("Bienvenido.")
    //solicitud y recepcion de variables cant de canciones y genero del album
    println("¿Cuántas canciones tiene el album?: ")
    var cant:Int = readLine()!!.toInt()
    println("¿De qué tipo de música es el album?: ")
    var albumType:String= readLine()!!.toString()
    //crear una instancia de la clase Album
    val myAlbum = Album(cant,albumType)
    //llamar los metodos de clase
    myAlbum.showSongsA()
    myAlbum.showCantRep()
    myAlbum.morePopularSong()
}