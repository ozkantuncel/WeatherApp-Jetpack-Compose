package com.ozkan.weatherapp.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen(route = "welcome_screen")
    object Home : Screen(route = "home_screen")
    object DailyWeather : Screen(route = "daily_screen")
}