package com.reychellv.fundamentoskotlin.RetoII

class Album(){
    // atributos
    var songTitle:String=""
    var artist:String=""
    var yearOfPost:Int=0
    var repNum=0
    //canciones
    val songsA = mutableListOf<List<String>>()

    //método constructor
    constructor(cantsongsA:Int, generoAlbum:String) : this() {
        for (i in 1..cantsongsA){
            println("Ingrese el titúlo de la cancion: ")
            this.songTitle = readLine()!!.toString()
            println("Ingrese el artista de la cancion: ")
            this.artist = readLine()!!.toString()
            println("Ingrese el año de publicacion: ")
            this.yearOfPost = readLine()!!.toInt()
            println("Ingrese el recuento de reproductions: ")
            this.repNum = readLine()!!.toInt()
            var lista = listOf<String>(this.songTitle,this.artist,this.yearOfPost.toString(),repNum.toString())
            songsA.add(lista)
        }
    }

    //metodos
    fun showSongsA(){
        for (i in 0 until songsA.size){
            println("Cancion ${i+1}")
            println("${songsA[i][0]} interpretada por ${songsA[i][1]}, se lanzo en ${songsA[i][2]} y cuenta con ${songsA[i][3]} reproductions")
        }
    }

    fun showCantRep(){
        for (i in 0 until songsA.size){
            if(songsA[i][3].toInt() < 1000){
                println("La cancion ${songsA[i][0]} tiene ${songsA[i][3]} reproductions y es poco popular ")
            }else{
                println("La cancion ${songsA[i][0]} tiene ${songsA[i][3]} reproductions y es muy popular ")
            }
        }
    }

    fun morePopularSong(){
        var popularSong=""
        var reproductions=0
        for (i in 0 until songsA.size){
            if(songsA[i][3].toInt() > reproductions){
                reproductions = songsA[i][3].toInt()
                popularSong = songsA[i][0]
            }else{
                popularSong = songsA[i][0]
            }
        }
        println("La cancion mas popular del album es: $popularSong ")
    }
}

fun main() {

}