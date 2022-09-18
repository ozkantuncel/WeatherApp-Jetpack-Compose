package com.ozkan.weatherapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ozkan.weatherapp.navigation.Screen
import com.ozkan.weatherapp.presentation.main_screen.WeatherState
import com.ozkan.weatherapp.presentation.main_screen.daily_weather_screen.PerDayHourlyWeather

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Bügün",
                fontSize = 20.sp,
                color = Color.White
            )
            Text(

                text = "7 Günlük Hava Durumu",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable
                    {
                        navController.navigate(Screen.DailyWeather.route)
                    }
            )
        }
        Spacer(modifier = modifier.height(16.dp))
        PerDayHourlyWeather(state = state)
    }

}