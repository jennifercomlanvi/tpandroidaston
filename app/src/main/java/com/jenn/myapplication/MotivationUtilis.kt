package com.jenn.myapplication

import okhttp3.Request

object MotivationUtilis {
    fun lodaMotivation(): Array<motivationItem> {

        var json = sendGet()

        val data  = RequestUtils.gson.fromJson(json, Array<motivationItem>::class.java)

        return data
    }

    fun sendGet(): String {
        println()
        //Création de la requête
        val request = Request.Builder()
            .url("https://motivational-content.p.rapidapi.com/quotes")
            .get()
            .addHeader("X-RapidAPI-Key", "7f5b8c3aecmsh2aa304413fa6ccep1670f2jsn49e3f8358c81")
            .addHeader("X-RapidAPI-Host", "motivational-content.p.rapidapi.com")
            .build()

        //Execution de la requête
        return RequestUtils.client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}