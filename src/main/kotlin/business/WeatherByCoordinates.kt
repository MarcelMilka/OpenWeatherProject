package business

import business.helperDataClasses.Clouds
import business.helperDataClasses.Coord
import business.helperDataClasses.Main
import business.helperDataClasses.Rain
import business.helperDataClasses.Sys
import business.helperDataClasses.Weather
import business.helperDataClasses.Wind

data class WeatherByCoordinates(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val rain: Rain,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)