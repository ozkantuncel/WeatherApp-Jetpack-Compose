package com.ozkan.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?timezone=GMT&hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
    ): WeatherDto

    @GET("v1/forecast?timezone=GMT&daily=temperature_2m_max,temperature_2m_min,weathercode,windspeed_10m_max")
    suspend fun getWeatherPerDayData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
    ): WeatherPerDayDto
}