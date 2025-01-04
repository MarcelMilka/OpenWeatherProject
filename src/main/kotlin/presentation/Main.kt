package org.example.presentation

import org.example.data.OpenWeatherRepository

fun main() {

    println("${OpenWeatherRepository.getWeatherByCity("Oslo")}")
    println("${OpenWeatherRepository.getWeatherByCoordinates(59.2, 40.1)}")
}