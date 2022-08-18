package com.ozkan.weatherapp.di

import com.ozkan.weatherapp.data.repository.WeatherRepositoryImpl
import com.ozkan.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLocationTracker(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository
}