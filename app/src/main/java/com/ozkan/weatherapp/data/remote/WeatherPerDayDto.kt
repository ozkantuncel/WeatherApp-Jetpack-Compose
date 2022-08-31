package com.ozkan.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherPerDayDto(
    @field:Json(name = "daily")
    val weatherPerDayData: WeatherPerDayDataDto
)