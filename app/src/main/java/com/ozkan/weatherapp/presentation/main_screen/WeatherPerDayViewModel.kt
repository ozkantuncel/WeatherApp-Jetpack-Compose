package com.ozkan.weatherapp.presentation.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozkan.weatherapp.domain.location.LocationTracker
import com.ozkan.weatherapp.domain.repository.WeatherRepository
import com.ozkan.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherPerDayViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherPerDayState())
        private set

    fun loadWeatherPerDayInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when (val result =
                    repository.getWeatherPerDayData(location.latitude, location.longitude)) {
                    is Resource.Success -> {
                        state = state.copy(
                            weatherPerDayInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            weatherPerDayInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Konum alınamadı, izinleri kabul ettiğiniziden ve GPS açık olduğundan emin olunuz"
                )
            }
        }
    }
}

