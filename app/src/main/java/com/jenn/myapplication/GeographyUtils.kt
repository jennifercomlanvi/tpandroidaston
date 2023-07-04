package com.jenn.myapplication

import okhttp3.Request

object GeographyUtils {

    fun lodaGeography(): Array<GeoItem> {

        var json = sendGet()

        val data  = RequestUtils.gson.fromJson(json, Array<GeoItem>::class.java)

        return data
    }

    fun sendGet(): String {
        println()
        //Création de la requête
        val request = Request.Builder()
            .url("https://geography4.p.rapidapi.com/apis/geography/v1/country?landlocked=true&startOfWeek=Monday&status=officially-assigned&unMember=true&independent=true")
            .get()
            .addHeader("X-RapidAPI-Key", "7f5b8c3aecmsh2aa304413fa6ccep1670f2jsn49e3f8358c81")
            .addHeader("X-RapidAPI-Host", "geography4.p.rapidapi.com")
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