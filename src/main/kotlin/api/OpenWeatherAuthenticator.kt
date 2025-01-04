package org.example.api

import okhttp3.Interceptor
import okhttp3.Response

object OpenWeatherAuthenticator: Interceptor {

    override fun intercept(p0: Interceptor.Chain): Response {

        val entryUrl = p0.request().url()

        val finalUrl =  entryUrl.newBuilder()
            .addQueryParameter("appid", OpenWeatherApiKey.KEY)
            .build()

        val request = p0.request()
            .newBuilder()
            .url(finalUrl)
            .build()

        val response = p0.proceed(request)

        return response
    }
}