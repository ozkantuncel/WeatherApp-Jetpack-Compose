package com.ozkan.weatherapp.presentation.main_screen.daily_weather_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ozkan.weatherapp.presentation.main_screen.WeatherState

@ExperimentalMaterialApi
@Composable
fun WeatherPerDayForecast(
    state: WeatherPerDayState,
    stateWeatherDay: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherPerDayInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            LazyColumn(
                content = {
                    items(count = data.count(),
                        itemContent = {
                            val weatherPerDayData = data[it]
                            PerDayWeatherDisplay(
                                weatherPerDayData = weatherPerDayData,
                                weatherState = stateWeatherDay,
                                modifier = Modifier
                                    .height(100.dp)
                                    .padding(horizontal = 16.dp)
                                    .fillMaxWidth(),
                                index = it
                            )
                        }
                    )
                })
        }

    }

}