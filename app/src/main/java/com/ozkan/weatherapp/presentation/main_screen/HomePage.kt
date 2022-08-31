package com.ozkan.weatherapp.presentation.on_boarding_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ozkan.weatherapp.presentation.WeatherCard
import com.ozkan.weatherapp.presentation.WeatherForecast
import com.ozkan.weatherapp.presentation.WeatherPerDayForecast
import com.ozkan.weatherapp.presentation.main_screen.WeatherPerDayViewModel
import com.ozkan.weatherapp.presentation.main_screen.WeatherViewModel
import com.ozkan.weatherapp.presentation.ui.theme.DarkBlue
import com.ozkan.weatherapp.presentation.ui.theme.DeepBlue

@Composable
fun HomePage(viewModel: WeatherViewModel,viewmodelPerDay:WeatherPerDayViewModel){

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
        ) {
            /*WeatherCard(
                state = viewModel.state,
                backgroundColor = DeepBlue
            )*/
            WeatherPerDayForecast(viewmodelPerDay.state, modifier = Modifier)

            //Spacer(modifier = Modifier.height(16.dp))
            //WeatherForecast(state = viewModel.state)
        }
    }
    if (viewModel.state.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }
    viewModel.state.error?.let { error ->
        Text(
            text = error,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
    }
}