package com.ozkan.weatherapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozkan.weatherapp.presentation.main_screen.PerDayWeatherDisplay
import com.ozkan.weatherapp.presentation.main_screen.WeatherPerDayState
import com.ozkan.weatherapp.presentation.main_screen.WeatherState

@Composable
fun WeatherPerDayForecast(
    state: WeatherPerDayState,
    modifier: Modifier = Modifier
) {
    state.weatherPerDayInfo?.weatherDataPerDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            LazyColumn(content = {
                items(data) { weatherData ->
                    PerDayWeatherDisplay(
                        weatherPerDayData = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            })
        }

    }

}