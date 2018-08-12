package mzx.weather.data.api

import mzx.weather.data.entity.WeatherEntity

interface WeatherApi {
    suspend fun getWeather(city: String): WeatherEntity
}