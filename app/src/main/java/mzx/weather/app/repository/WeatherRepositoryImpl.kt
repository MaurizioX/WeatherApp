package mzx.weather.app.repository

import mzx.weather.data.api.WeatherApi
import mzx.weather.data.entity.*
import mzx.weather.domain.element.*
import mzx.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherApi: WeatherApi)
    : WeatherRepository {
    override suspend fun getWeather(city: String): WeatherElement = weatherApi.getWeather(city).transform
}

private val WeatherEntity.transform: WeatherElement
    get() = WeatherElement(dt, coord.transform, visibility, weather?.map { it.transform },
            name, cod, main.transform, clouds.transform, id, sys.transform, base, wind.transform)
private val WindEntity.transform: WindElement
    get() = WindElement(deg, speed)
private val SysEntity.transform: SysElement
    get() = SysElement(country, sunrise, sunset, id, type, message)
private val CloudsEntity.transform: CloudsElement
    get() = CloudsElement(all)
private val MainEntity.transform: MainElement
    get() = MainElement(temp, tempMin, humidity, pressure, tempMax)
private val WeatherItemEntity.transform: WeatherItemElement
    get() = WeatherItemElement(icon, description, main, id)
private val CoordEntity.transform: CoordElement
    get() = CoordElement(lon, lat)
