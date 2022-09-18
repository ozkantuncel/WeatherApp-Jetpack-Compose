package com.ozkan.weatherapp.presentation.main_screen.daily_weather_screen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ozkan.weatherapp.presentation.HourlyWeatherDisplay
import com.ozkan.weatherapp.presentation.main_screen.WeatherState


@Composable
fun PerDayHourlyWeather(
    state: WeatherState,
    index:Int? =0
) {
    state.weatherInfo?.weatherDataPerDay?.get(index)?.let { data ->
        LazyRow(content = {
            items(data) { weatherData ->
                HourlyWeatherDisplay(
                    weatherData = weatherData,
                    modifier = Modifier
                        .height(100.dp)
                        .padding(horizontal = 16.dp)
                )
            }
        })
    }
}