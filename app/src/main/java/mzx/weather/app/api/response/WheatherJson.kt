package mzx.weather.app.api.response


import com.fasterxml.jackson.annotation.JsonProperty

data class CoordJson(@JsonProperty("lon")
                     val lon: Double = 0.0,
                     @JsonProperty("lat")
                     val lat: Double = 0.0)


data class WindJson(@JsonProperty("deg")
                    val deg: Int = 0,
                    @JsonProperty("speed")
                    val speed: Double = 0.0)


data class WeatherItemJson(@JsonProperty("icon")
                           val icon: String = "",
                           @JsonProperty("description")
                           val description: String = "",
                           @JsonProperty("main")
                           val main: String = "",
                           @JsonProperty("id")
                           val id: Int = 0)


data class CloudsJson(@JsonProperty("all")
                      val all: Int = 0)


data class WeatherJson(@JsonProperty("dt")
                       val dt: Int = 0,
                       @JsonProperty("coord")
                       val coord: CoordJson,
                       @JsonProperty("visibility")
                       val visibility: Int = 0,
                       @JsonProperty("weather")
                       val weather: List<WeatherItemJson>?,
                       @JsonProperty("name")
                       val name: String = "",
                       @JsonProperty("cod")
                       val cod: Int = 0,
                       @JsonProperty("main")
                       val main: MainJson,
                       @JsonProperty("clouds")
                       val clouds: CloudsJson,
                       @JsonProperty("id")
                       val id: Int = 0,
                       @JsonProperty("sys")
                       val sys: SysJson,
                       @JsonProperty("base")
                       val base: String = "",
                       @JsonProperty("wind")
                       val wind: WindJson)


data class SysJson(@JsonProperty("country")
                   val country: String = "",
                   @JsonProperty("sunrise")
                   val sunrise: Int = 0,
                   @JsonProperty("sunset")
                   val sunset: Int = 0,
                   @JsonProperty("id")
                   val id: Int = 0,
                   @JsonProperty("type")
                   val type: Int = 0,
                   @JsonProperty("message")
                   val message: Double = 0.0)


data class MainJson(@JsonProperty("temp")
                    val temp: Double = 0.0,
                    @JsonProperty("temp_min")
                    val tempMin: Double = 0.0,
                    @JsonProperty("humidity")
                    val humidity: Int = 0,
                    @JsonProperty("pressure")
                    val pressure: Int = 0,
                    @JsonProperty("temp_max")
                    val tempMax: Double = 0.0)


