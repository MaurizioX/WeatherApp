package mzx.weather.domain.element

data class CoordElement(
        val lon: Double = 0.0,
        val lat: Double = 0.0)


data class WindElement(val deg: Int = 0,
                       val speed: Double = 0.0)


data class WeatherItemElement(val icon: String = "",
                              val description: String = "",
                              val main: String = "",
                              val id: Int = 0)


data class CloudsElement(val all: Int = 0)


data class WeatherElement(val dt: Int = 0,
                          val coord: CoordElement,
                          val visibility: Int = 0,
                          val weather: List<WeatherItemElement>?,
                          val name: String = "",
                          val cod: Int = 0,
                          val main: MainElement,
                          val clouds: CloudsElement,
                          val id: Int = 0,
                          val sys: SysElement,
                          val base: String = "",
                          val wind: WindElement)


data class SysElement(val country: String = "",
                      val sunrise: Int = 0,
                      val sunset: Int = 0,
                      val id: Int = 0,
                      val type: Int = 0,
                      val message: Double = 0.0)


data class MainElement(val temp: Double = 0.0,
                       val tempMin: Double = 0.0,
                       val humidity: Int = 0,
                       val pressure: Int = 0,
                       val tempMax: Double = 0.0)

data class ForecastElement(val city: CityElement,
                           val cnt: Int = 0,
                           val cod: String = "",
                           val message: Double = 0.0,
                           val list: List<ListItemElement>?)

data class ListItemElement(
        val dt: Int = 0,
        val dtTxt: String = "",
        val snow: SnowElement?,
        val weather: List<WeatherItemElement>?,
        val main: MainElement,
        val clouds: CloudsElement,
        val sys: SysElement,
        val wind: WindElement, val rain: SnowElement?)

data class SnowElement(val snow: Double?)

data class CityElement(val country: String = "",
                      val coord: CoordElement,
                      val name: String = "",
                      val id: Int = 0,
                      val population: Int?)



