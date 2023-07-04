package com.jenn.myapplication

import java.util.Random
//Motivation Api

class motivation : ArrayList<motivationItem>()

data class motivationItem(
    val id: String,
    val quote: String
)
//geography
class Geo : ArrayList<GeoItem>()

data class GeoItem(
    val altSpellings: List<Any>,
    val area: Int,
    val borders: List<Any>,
    val capital: List<Capital>,
    val car: Car,
    val cca2: String,
    val cca3: String,
    val ccn3: String,
    val cioc: String,
    val coatOfArms: CoatOfArms,
    val continents: List<Any>,
    val currencies: List<Currency>,
    val demonyms: List<Demonym>,
    val fifa: String,
    val flag: String,
    val flags: Flags,
    val gdp: Gdp,
    val gini: Gini,
    val href: String,
    val idd: Idd,
    val independent: Boolean,
    val landlocked: String,
    val languages: List<Language>,
    val latLng: LatLngX,
    val maps: Maps,
    val name: Name,
    val population: Int,
    val postalCode: PostalCode,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<Any>,
    val tld: List<Any>,
    val unMember: Boolean
)

data class Capital(
    val latLng: LatLngX,
    val name: String
)

data class Car(
    val side: String,
    val signs: List<Any>
)

data class CoatOfArms(
    val png: String,
    val svg: String
)

data class Currency(
    val alphaCode: String,
    val minorUnit: Int,
    val name: String,
    val numericCode: Int,
    val symbol: String
)

data class Demonym(
    val f: String,
    val langCode: String,
    val m: String
)

data class Flags(
    val alt: String,
    val png: String,
    val svg: String
)

data class Gdp(
    val currency: String,
    val value: Double,
    val year: Int
)

data class Gini(
    val value: Int,
    val year: Int
)

data class Idd(
    val root: String,
    val suffixes: List<Any>
)

data class Language(
    val code: String,
    val name: String
)

data class LatLngX(
    val lat: Double,
    val lng: Double
)

data class Maps(
    val googleMaps: String,
    val openStreetMaps: String
)

data class Name(
    val common: String,
    val nativeName: List<NativeName>,
    val official: String,
    val translations: List<Translation>
)

data class PostalCode(
    val format: String,
    val regex: String
)

data class NativeName(
    val common: String,
    val lang: String,
    val official: String
)

data class Translation(
    val common: String,
    val lang: String,
    val official: String
)
//beans.kt miniproject
data class WeatherBean (
    var name :String,
    var main:TempBean,
    var wind:WindBean
)
data class TempBean(
    var temp: Double
)
data class WindBean(
    var speed: Double
)

//exercice du lundi
class CarBean(var marque: String, var model: String) {
    var couleur: String = "grise"
}

class HouseBean(var couleur: String, largeur: Int, longueur: Int) {
    var surface: Int = largeur * longueur

    fun print() {
        println("La maison $couleur fait $surface m²")
    }
}
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