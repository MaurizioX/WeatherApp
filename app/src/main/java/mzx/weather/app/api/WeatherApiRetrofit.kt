package mzx.weather.app.api

import kotlinx.coroutines.experimental.Deferred
import mzx.weather.app.api.response.ForecastWeatherJson
import mzx.weather.app.api.response.WeatherJson
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiRetrofit {
    @GET("/data/2.5/weather")
    fun getWeather(@Query("q") city: String,
                   @Query("APPID") appId: String,
                   @Query("units") unit: String): Deferred<WeatherJson>

    @GET("/data/2.5/forecast")
    fun getForecastWeather(@Query("q") city: String,
                           @Query("APPID") appId: String,
                           @Query("units") unit: String): Deferred<ForecastWeatherJson>
}