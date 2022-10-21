package com.ozkan.weatherapp.presentation.main_screen

import com.ozkan.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null

)
