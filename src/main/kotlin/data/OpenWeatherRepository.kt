package org.example.data

import business.OpenWeatherResponse
import business.WeatherByCity
import business.WeatherByCoordinates
import org.example.api.OpenWeatherClient

object OpenWeatherRepository {

    private val client = OpenWeatherClient.openWeatherClient

    fun getWeatherByCoordinates(lat: Double, lon: Double): OpenWeatherResponse<WeatherByCoordinates> {

        return try {

            val response = client
                .getWeatherByCoordinates(mapOf("lat" to lat, "lon" to lon))
                .execute()

            if (response.isSuccessful) {

                OpenWeatherResponse(
                    code = response.code(),
                    responseMessage = response.message(),
                    data = response.body()
                )
            }

            else {

                println("${response.errorBody()?.string()}")
                OpenWeatherResponse(
                    code = response.code(),
                    responseMessage = response.message(),
                    data = null
                )
            }

        } catch (e: Exception) {

            OpenWeatherResponse(
                code = 500,
                responseMessage = "Internal Server Error: ${e.message}",
                data = null
            )
        }
    }

    fun getWeatherByCity(city: String): OpenWeatherResponse<WeatherByCity> {

        return try {

            val response = client
                .getWeatherByCity(city)
                .execute()

            if (response.isSuccessful) {

                OpenWeatherResponse<WeatherByCity>(
                    code = response.code(),
                    responseMessage = response.message(),
                    data = response.body()
                )
            }

            else {

                OpenWeatherResponse<WeatherByCity>(
                    code = response.code(),
                    responseMessage = response.message(),
                    data = null
                )
            }

        }

        catch (e: Exception) {

            OpenWeatherResponse(
                code = 500,
                responseMessage = "Internal Server Error: ${e.message}",
                data = null
            )
        }
    }
}