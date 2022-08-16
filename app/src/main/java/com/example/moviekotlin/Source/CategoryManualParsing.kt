package com.example.moviekotlin.Source

import com.example.moviekotlin.Api.CategoryApi
import com.example.moviekotlin.Model.*
import com.google.gson.Gson
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.net.URL
import java.net.URLConnection

class CategoryManualParsing : CategoryApi {

    override suspend fun getCategory(): Category {

        val url = URL("https://swapi.dev/api")
        val connection: URLConnection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader: BufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()

        for (line:String in bufferedReader.readLines()){
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val jsonMeta: String = stringBuffer.toString()

        return Gson().fromJson(jsonMeta,Category::class.java)

//        val jsonObject = JSONObject(jsonMeta)
//        val jsonArray: JSONArray = jsonObject.getJSONArray("movies")
//        val jsonObjectMovie: JSONObject = jsonArray.getJSONObject(0)
//
//        val movieName = jsonObjectMovie.getString("movie")
//        val yearData = jsonObjectMovie.getInt("year")
//        val imgData = jsonObjectMovie.getString("image")
//
//        return Movies(listOf(Movie(movieName, yearData, imgData))
//        )
    }

    override suspend fun getDetailPeople(urls: String): DetailPeopleModel {
        val url = URL(urls)
        val connection: URLConnection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader: BufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()

        for (line:String in bufferedReader.readLines()){
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val jsonMeta: String = stringBuffer.toString()

        return Gson().fromJson(jsonMeta,DetailPeopleModel::class.java)
    }

    override suspend fun getDetailFilms(urls: String): DetailFilmModel {
        val url = URL(urls)
        val connection: URLConnection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader: BufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()

        for (line:String in bufferedReader.readLines()){
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val jsonMeta: String = stringBuffer.toString()

        return Gson().fromJson(jsonMeta,DetailFilmModel::class.java)
    }

    override suspend fun getDetailPlanet(urls: String): DetailPlanetModel {
        val url = URL(urls)
        val connection: URLConnection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader: BufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()

        for (line:String in bufferedReader.readLines()){
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val jsonMeta: String = stringBuffer.toString()

        return Gson().fromJson(jsonMeta,DetailPlanetModel::class.java)
    }

    override suspend fun getDetailSpecies(urls: String): DetailSpeciesModel {
        val url = URL(urls)
        val connection: URLConnection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader: BufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()

        for (line:String in bufferedReader.readLines()){
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val jsonMeta: String = stringBuffer.toString()

        return Gson().fromJson(jsonMeta,DetailSpeciesModel::class.java)
    }

    override suspend fun getDetailVehicles(urls: String): DetailVehiclesModel {
        val url = URL(urls)
        val connection: URLConnection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader: BufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()

        for (line:String in bufferedReader.readLines()){
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val jsonMeta: String = stringBuffer.toString()

        return Gson().fromJson(jsonMeta,DetailVehiclesModel::class.java)
    }

    override suspend fun getDetailStarship(urls: String): DetailStarshipModel {
        val url = URL(urls)
        val connection: URLConnection = url.openConnection()
        connection.connect()

        val bufferedInputStream = BufferedInputStream(connection.getInputStream())
        val bufferedReader: BufferedReader = bufferedInputStream.bufferedReader()

        val stringBuffer = StringBuffer()

        for (line:String in bufferedReader.readLines()){
            stringBuffer.append(line)
        }

        bufferedReader.close()

        val jsonMeta: String = stringBuffer.toString()

        return Gson().fromJson(jsonMeta,DetailStarshipModel::class.java)
    }

}