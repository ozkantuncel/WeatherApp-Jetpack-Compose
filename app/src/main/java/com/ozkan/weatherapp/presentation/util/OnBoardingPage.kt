package com.ozkan.weatherapp.presentation.util

import androidx.annotation.DrawableRes
import com.ozkan.weatherapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.ic_sunny,
        title = "Hava Açık",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
    object Second : OnBoardingPage(
        image = R.drawable.ic_cloudy,
        title = "Hava Bulutlu",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
    object Third : OnBoardingPage(
        image = R.drawable.ic_rainshower,
        title = "Hava Yağmurlu",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}
