package business

import business.helperDataClasses.Clouds
import business.helperDataClasses.Coord
import business.helperDataClasses.Main
import business.helperDataClasses.Sys
import business.helperDataClasses.Weather
import business.helperDataClasses.Wind

data class WeatherByCity(
    val base: String,
    val clouds: Clouds,
    val cod: Double,
    val coord: Coord,
    val dt: Double,
    val id: Double,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Double,
    val visibility: Double,
    val weather: List<Weather>,
    val wind: Wind
)
