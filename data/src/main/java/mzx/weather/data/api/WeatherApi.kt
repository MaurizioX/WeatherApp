package mzx.weather.data.api

import mzx.weather.data.entity.ForecastEntity
import mzx.weather.data.entity.WeatherEntity

interface WeatherApi {
    suspend fun getWeather(city: String): WeatherEntity

    suspend fun getForecast(city: String): ForecastEntity
}