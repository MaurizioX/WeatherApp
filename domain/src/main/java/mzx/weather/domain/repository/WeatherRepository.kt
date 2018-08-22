package mzx.weather.domain.repository

import mzx.weather.domain.element.ForecastElement
import mzx.weather.domain.element.WeatherElement

interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherElement
    suspend fun getForecast(s: String): ForecastElement
}