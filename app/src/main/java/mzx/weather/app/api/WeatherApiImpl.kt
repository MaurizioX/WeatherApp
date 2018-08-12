package mzx.weather.app.api

import mzx.weather.app.api.response.*
import mzx.weather.app.config.Environment
import mzx.weather.data.api.WeatherApi
import mzx.weather.data.entity.*
import javax.inject.Inject

class WeatherApiImpl @Inject constructor(private val weatherApiRetrofit: WeatherApiRetrofit,
                                         private val environment: Environment)
    : WeatherApi {
    override suspend fun getWeather(city: String): WeatherEntity =
            weatherApiRetrofit.getWeather(city, environment.apiKey).await().transform
}

private val WeatherJson.transform: WeatherEntity
    get() = WeatherEntity(dt, coord.transform, visibility, weather?.map {
        it.transform
    }, name, cod, main.transform, clouds.transform, id, sys.transform,
            base, wind.transform)

private val WeatherItemJson.transform: WeatherItemEntity
    get() = WeatherItemEntity(icon, description, main)

private val WindJson.transform: WindEntity
    get() = WindEntity(deg, speed)

private val SysJson.transform: SysEntity
    get() = SysEntity(country, sunrise, sunset, id, type, message)

private val CloudsJson.transform: CloudsEntity
    get() = CloudsEntity(all)

private val MainJson.transform: MainEntity
    get() = MainEntity(temp, tempMin, humidity, pressure, tempMax)

private val CoordJson.transform: CoordEntity
    get() = CoordEntity(lon, lat)
