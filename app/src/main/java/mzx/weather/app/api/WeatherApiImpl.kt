package mzx.weather.app.api

import mzx.weather.app.api.response.*
import mzx.weather.app.config.Environment
import mzx.weather.data.api.WeatherApi
import mzx.weather.data.entity.*
import javax.inject.Inject

class WeatherApiImpl @Inject constructor(private val weatherApiRetrofit: WeatherApiRetrofit,
                                         private val environment: Environment)
    : WeatherApi {
    override suspend fun getForecast(city: String): ForecastEntity = weatherApiRetrofit
            .getForecastWeather(city, environment.apiKey, environment.unit).await().transform

    override suspend fun getWeather(city: String): WeatherEntity =
            weatherApiRetrofit.getWeather(city, environment.apiKey, environment.unit).await().transform
}

private val ForecastWeatherJson.transform: ForecastEntity
    get() = ForecastEntity(city.transform, cnt, cod, message, list?.map { it.transform })

private val City.transform: CityEntity
    get() = CityEntity(country = country, name = name, coord = coord.transform, id = id, population = population)

private val ListItemJson.transform: ListItemEntity
    get() = ListItemEntity(dt = dt, clouds = clouds.transform, dtTxt = dtTxt, main = main.transform, rain = rain?.transform,
            snow = snow?.transform, sys = sys.transform, weather = weather?.map { it.transform }, wind = wind.transform)

private val Snow.transform: SnowEntity
    get() = SnowEntity(snow)

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
