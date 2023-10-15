package com.example.musicapp


import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.Call

interface AppInterface {

    @Headers("X-RapidAPI-Key: d613268063msh25376f41583d2a3p193e2ejsnfdf116bcec17",
        "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String): Call<MyData>
}
