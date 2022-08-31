package com.ozkan.weatherapp.presentation.main_screen

import com.ozkan.weatherapp.domain.weather.WeatherPerDayInfo

data class WeatherPerDayState(
    val weatherPerDayInfo: WeatherPerDayInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
