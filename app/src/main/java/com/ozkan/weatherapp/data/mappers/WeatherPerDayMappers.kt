package com.ozkan.weatherapp.data.mappers

import com.ozkan.weatherapp.data.remote.WeatherPerDayDataDto
import com.ozkan.weatherapp.data.remote.WeatherPerDayDto
import com.ozkan.weatherapp.domain.weather.WeatherPerData
import com.ozkan.weatherapp.domain.weather.WeatherPerDayInfo
import com.ozkan.weatherapp.domain.weather.WeatherType
import java.time.LocalDate
 import java.time.format.DateTimeFormatter

private data class IndexedWeatherPerDayData(
    val index: Int,
    val data: WeatherPerData
)

fun WeatherPerDayDataDto.toWeatherPerDayDataMap(): Map<Int, List<WeatherPerData>> {
    return time.mapIndexed { index, time ->
        val temperaturemaxday = temperaturemaxday[index]
        val temperaturemin = temperatureminday[index]
        val weatherCodeDay = weatherCodesday[index]
        val windSpeedsmaxday = windSpeedsmaxday[index]
        IndexedWeatherPerDayData(
            index = index,
            data = WeatherPerData(
                time = LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                temperaturemaxday = temperaturemaxday,
                temperatureminday = temperaturemin,
                windSpeedsmaxday = windSpeedsmaxday,
                weatherType = WeatherType.fromWMO(weatherCodeDay),
            )
        )
    }.groupBy {
        it.index / 7
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherPerDayDto.toWeatherPerDayInfo(): WeatherPerDayInfo {
    val weatherPerDay = weatherPerDayData.toWeatherPerDayDataMap()
    return WeatherPerDayInfo(
        weatherDataPerDay = weatherPerDay
    )
}