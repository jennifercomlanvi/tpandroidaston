package com.jenn.myapplication

import java.util.Random

class CarBean(var marque: String, var model: String) {
    var couleur: String = "grise"
}

class HouseBean(var couleur: String, largeur: Int, longueur: Int) {
    var surface: Int = largeur * longueur

    fun print() {
        println("La maison $couleur fait $surface m²")
    }
}
//beans.kt
class TownBean(val city: String, val cp: String) {
    var country: String? = null
}
data class DataTownBean(val city: String, val cp: String) {
    var country: String? = null
}

class PrintRandomIntBean(var max : Int){
    private val random: Random = Random()
    init {
        println("init")
        repeat(3) {
            val randomNumber = random.nextInt(max)
            println(randomNumber)
        }
    }

    constructor() : this(100) {
        println("constructeur")
        repeat(4) {
            val randomNumber = random.nextInt(max)
            println(randomNumber)
        }
    }
}
fun main() {
    val seatLeon = CarBean("Seat", "Leon")
    println("Marque: ${seatLeon.marque}")
    println("Modèle: ${seatLeon.model}")
    println("Couleur: ${seatLeon.couleur}")
    var maison = HouseBean("rouge", 5, 6)
    maison.print()

    val city = TownBean("Toulouse", "31000")
    city.country = "toto"
    val city2 = TownBean("Toulouse", "31000")
    city2.country = "toto2"

    val dataCity = DataTownBean("Toulouse", "31000")
    dataCity.country = "toto"
    val dataCity2 = DataTownBean("Toulouse", "31000")
    dataCity2.country = "toto2"

    println("city=$city") //city=TownBean@123245
    println("dataCity=$dataCity")//dataCity=DataTownBean(city=Toulouse, cp=31000)

    println("== : ${city == city2}") //== : false
    println("equals : ${city.equals(city2)}")// equals : false
    println("=== : ${city === city2}") //=== : false

    println("data == : ${dataCity == dataCity2}") // data == : true
    println("data equals : ${dataCity.equals(dataCity2)}")//data equals : true
    println("data === : ${dataCity === dataCity2}") //data === : false
}