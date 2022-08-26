package com.ozkan.weatherapp.presentation.on_boarding_screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.ozkan.weatherapp.navigation.Screen
import com.ozkan.weatherapp.presentation.ui.theme.DarkBlue
import com.ozkan.weatherapp.presentation.ui.theme.TitleBlue
import com.ozkan.weatherapp.presentation.util.OnBoardingPage


@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun WelcomeScreen(
    navController: NavController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { positoin ->
            PagerScreen(onBoardingPage = pages[positoin], pagerState, navController,welcomeViewModel)
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun PagerScreen(
    onBoardingPage: OnBoardingPage,
    pagerState: PagerState,
    navController: NavController,
    welcomeViewModel: WelcomeViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = null
        )

        Spacer(modifier = Modifier.weight(1f))

        Card(
            elevation = 0.dp,
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            modifier = Modifier
                .align(Alignment.Start)
                .animateContentSize(
                    tween(
                        durationMillis = 500,
                        delayMillis = 10,
                        easing = LinearOutSlowInEasing
                    )
                ),
            backgroundColor = Color.White,
            contentColor = Color.Transparent
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = onBoardingPage.title,
                    style = TextStyle(TitleBlue),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                )
                Text(
                    modifier = Modifier.padding(all = 15.dp),
                    text = onBoardingPage.description,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,

                    )

                FinishButton(
                    modifier = Modifier,
                    pagerState = pagerState
                ) {
                    welcomeViewModel.saveOnBoardingState(completed = true)
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                }

                HorizontalPagerIndicator(
                    modifier = Modifier.padding(all = 10.dp),
                    pagerState = pagerState
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text(text = "Geç")
            }
        }
    }
}
