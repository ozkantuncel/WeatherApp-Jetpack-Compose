package com.ozkan.weatherapp.domain.weather

import java.time.LocalDate

data class WeatherPerData(
    val time: LocalDate,
    val temperaturemaxday: Double,
    val temperatureminday: Double,
    val windSpeedsmaxday: Double,
    val weatherType: WeatherType
)
