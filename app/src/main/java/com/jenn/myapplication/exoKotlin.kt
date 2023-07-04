package com.jenn.myapplication

fun main() {
    var v1 : String = "Coucou Jenny"
    //Au moins 1 caractère qui n'est pas un espace
    if(v1.isNotBlank()){
        println(v1.uppercase())
    }

    var v2 : String? = "v2"
    println(v2?.uppercase())

    var v3 : String? = null
    println(v3?.uppercase())
    if(v3.isNullOrBlank()){
        //ctrl click
        println("Toto")
    }

    //alt + entrée
    var v4 = v3 + v3
    println(v4)

    println( min(3,4,5))
    println( minimum(3,4,5))
    println(pair(2))
    println(pair(3))
    myPrint("toto")
    val total1 = boulangerie(croissants = 2)
    val total2 = boulangerie(baguettes = 2, sandwiches = 3)
    println("total1 $total1")
    println("total2 $total2")

}

fun min(a:Int, b:Int, c:Int) : Int{
    if(a < b && a < c) {
        return a
    }
    else if(b < a && b < c) {
        return b
    }
    else {
        return c
    }
}
fun minimum (a:Int, b:Int, c:Int) = minOf(a,b, c)
fun pair(c:Int) = c%2 == 0
fun myPrint(chaine : String) = println("##$chaine##")

fun boulangerie(croissants: Int = 0, baguettes: Int = 0, sandwiches: Int = 0): Double =
    croissants * PRIX_CROISSANT + baguettes * PRIX_BAGUETTE + sandwiches * PRIX_SANDWICH
