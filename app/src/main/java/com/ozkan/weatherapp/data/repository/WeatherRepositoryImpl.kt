package com.ozkan.weatherapp.data.repository

import com.ozkan.weatherapp.data.mappers.toWeatherInfo
import com.ozkan.weatherapp.data.mappers.toWeatherPerDayInfo
import com.ozkan.weatherapp.data.remote.WeatherApi
import com.ozkan.weatherapp.domain.repository.WeatherRepository
import com.ozkan.weatherapp.domain.util.Resource
 import com.ozkan.weatherapp.domain.weather.WeatherInfo
import com.ozkan.weatherapp.domain.weather.WeatherPerDayInfo
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "Bilinmeyen bir hata")
        }
    }
    override suspend fun getWeatherPerDayData(lat: Double, long: Double): Resource<WeatherPerDayInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherPerDayData(
                    lat = lat,
                    long = long
                ).toWeatherPerDayInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(message = e.message ?: "Bilinmeyen bir hata")
        }
    }
}