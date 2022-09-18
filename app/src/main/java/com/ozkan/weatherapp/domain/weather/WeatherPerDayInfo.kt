package com.ozkan.weatherapp.domain.weather

data class WeatherPerDayInfo(
    val weatherDataPerDay: Map<Int, List<WeatherPerData>>
)