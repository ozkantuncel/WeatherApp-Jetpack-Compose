package com.ozkan.weatherapp.presentation.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ozkan.weatherapp.domain.weather.WeatherData
import com.ozkan.weatherapp.domain.weather.WeatherPerData
import java.time.format.DateTimeFormatter

@Composable
fun PerDayWeatherDisplay(
    weatherPerDayData: WeatherPerData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    val formattedTimeDayAndMonth = remember(weatherPerDayData) {
        weatherPerDayData.time.format(
            DateTimeFormatter.ofPattern("MMM dd")
        )
    }

    val formattedTimeDayName = remember(weatherPerDayData) {
        weatherPerDayData.time.format(
            DateTimeFormatter.ofPattern("EEEE")
        )
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column() {
            Text(
                text = formattedTimeDayName,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = formattedTimeDayAndMonth,
                color = Color.LightGray
            )
        }
        Text(
            text = "${weatherPerDayData.temperaturemaxday}C",
            color = Color.LightGray
        )
        println("${weatherPerDayData.temperatureminday}C")
        Image(
            painter = painterResource(id = weatherPerDayData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )

    }

}