package com.ozkan.weatherapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ozkan.weatherapp.presentation.main_screen.WeatherPerDayViewModel
import com.ozkan.weatherapp.presentation.main_screen.WeatherViewModel
import com.ozkan.weatherapp.presentation.on_boarding_screens.HomePage
import com.ozkan.weatherapp.presentation.on_boarding_screens.WelcomeScreen

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
    viewModel: WeatherViewModel,
    viewModelPerDay: WeatherPerDayViewModel
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomePage(viewModel,viewModelPerDay)
        }
    }
}