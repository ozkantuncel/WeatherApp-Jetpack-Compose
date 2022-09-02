package com.ozkan.weatherapp.presentation.main_screen.daily_weather_screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ozkan.weatherapp.domain.weather.WeatherData
import com.ozkan.weatherapp.domain.weather.WeatherPerData
import com.ozkan.weatherapp.presentation.main_screen.WeatherState
import java.time.format.DateTimeFormatter

@ExperimentalMaterialApi
@Composable
fun PerDayWeatherDisplay(
    weatherPerDayData: WeatherPerData,
    weatherState: WeatherState,
    index: Int? = 0,
    modifier: Modifier
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

    var expand by remember { mutableStateOf(false) }
    var stroke by remember { mutableStateOf(1) }

    Card(
        modifier = Modifier
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 400,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(8.dp),
        backgroundColor = Color.Gray,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(stroke.dp, Color.White),
        onClick = {
            expand = !expand
            stroke = if (expand) 2 else 1
            println(index)
        }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = modifier,
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

                Image(
                    painter = painterResource(id = weatherPerDayData.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(40.dp)
                )

                Column() {
                    Text(
                        text = "En Yüksek: ${weatherPerDayData.temperaturemaxday}C",
                        color = Color.LightGray
                    )
                    Text(
                        text = "En Düşük: ${weatherPerDayData.temperatureminday}C",
                        color = Color.LightGray
                    )
                }
            }
            if (expand) {
                PerDayHourlyWeather(state = weatherState, index = index)
            }
        }

    }


}