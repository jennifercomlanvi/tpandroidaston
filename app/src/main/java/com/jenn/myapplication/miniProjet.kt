package com.jenn.myapplication

fun main() {
    //Lazy loading + une seule instanciation
    var html = RequestUtils.sendGet("https://www.google.fr")
    println(html)
}