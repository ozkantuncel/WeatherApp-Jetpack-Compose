package com.ozkan.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherPerDayDataDto(
    val time: List<String>,
    @field:Json(name = "temperature_2m_max")
    val temperaturemaxday: List<Double>,
    @field:Json(name = "temperature_2m_min")
    val temperatureminday: List<Double>,
    @field:Json(name = "weathercode")
    val weatherCodesday: List<Int>,
    @field:Json(name = "windspeed_10m_max")
    val windSpeedsmaxday: List<Double>
)