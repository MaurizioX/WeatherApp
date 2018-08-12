package mzx.weather.data.entity


data class CoordEntity(
        val lon: Double = 0.0,
        val lat: Double = 0.0)


data class WindEntity(val deg: Int = 0,
                      val speed: Double = 0.0)


data class WeatherItemEntity(val icon: String = "",
                             val description: String = "",
                             val main: String = "",
                             val id: Int = 0)


data class CloudsEntity(val all: Int = 0)


data class WeatherEntity(val dt: Int = 0,
                         val coord: CoordEntity,
                         val visibility: Int = 0,
                         val weather: List<WeatherItemEntity>?,
                         val name: String = "",
                         val cod: Int = 0,
                         val main: MainEntity,
                         val clouds: CloudsEntity,
                         val id: Int = 0,
                         val sys: SysEntity,
                         val base: String = "",
                         val wind: WindEntity)


data class SysEntity(val country: String = "",
                     val sunrise: Int = 0,
                     val sunset: Int = 0,
                     val id: Int = 0,
                     val type: Int = 0,
                     val message: Double = 0.0)


data class MainEntity(val temp: Double = 0.0,
                      val tempMin: Double = 0.0,
                      val humidity: Int = 0,
                      val pressure: Int = 0,
                      val tempMax: Double = 0.0)



