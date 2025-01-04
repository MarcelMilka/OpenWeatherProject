package org.example.api

import business.WeatherByCity
import business.WeatherByCoordinates
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface OpenWeatherApi {

    @GET("weather")
    fun getWeatherByCoordinates(@QueryMap coordinates: Map<String, Double>): Call<WeatherByCoordinates>

    @GET("weather")
    fun getWeatherByCity(@Query("q") city: String): Call<WeatherByCity>
}