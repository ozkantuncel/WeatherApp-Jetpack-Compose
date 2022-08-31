package com.ozkan.weatherapp.domain.repository

import com.ozkan.weatherapp.domain.util.Resource
import com.ozkan.weatherapp.domain.weather.WeatherInfo
import com.ozkan.weatherapp.domain.weather.WeatherPerDayInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
    suspend fun getWeatherPerDayData(lat: Double, long: Double): Resource<WeatherPerDayInfo>

}