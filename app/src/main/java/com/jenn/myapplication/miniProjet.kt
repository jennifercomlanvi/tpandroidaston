package com.jenn.myapplication

fun main() {
    //Lazy loading + une seule instanciation
    //var html = RequestUtils.sendGet("https://www.google.fr")
    //println(html)
    val weather = RequestUtils.loadWeather("Mulhouse")
    println("Il fait ${weather.main.temp}° à ${weather.name}")
    println("Il fait ${weather.main.temp}° à ${weather.name} avec un vent de ${weather.wind.speed} m/s")

}