package com.ozkan.weatherapp.presentation.main_screen.daily_weather_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ozkan.weatherapp.presentation.main_screen.WeatherViewModel
import com.ozkan.weatherapp.presentation.ui.theme.DarkBlue


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WeatherPerDayPage(
    viewModel: WeatherPerDayViewModel,
    viewModelWeather: WeatherViewModel
) {
    if (viewModel.state.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
        ) {
            CircularProgressIndicator(color = Color.White)
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DarkBlue),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                WeatherPerDayForecast(state = viewModel.state, stateWeatherDay = viewModelWeather.state)
            }
        }
    }
    viewModel.state.error?.let { error ->
        Text(
            text = error,
            color = Color.Red,
            textAlign = TextAlign.Center,
        )
    }
}