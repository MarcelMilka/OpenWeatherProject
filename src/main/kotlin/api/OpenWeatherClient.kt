package org.example.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object OpenWeatherClient {

    private val authenticatedClient = OkHttpClient
        .Builder()
        .addInterceptor(OpenWeatherAuthenticator)
        .connectTimeout(10, TimeUnit.SECONDS) // set timeout for connections
        .writeTimeout(10, TimeUnit.SECONDS) // set timeout for uploads
        .readTimeout(10, TimeUnit.SECONDS) // set timeout for downloads
        .build()

    val openWeatherClient = Retrofit
        .Builder()
        .client(this.authenticatedClient)
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(OpenWeatherApi::class.java)
}