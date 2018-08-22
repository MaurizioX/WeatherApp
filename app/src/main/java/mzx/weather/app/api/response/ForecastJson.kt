package mzx.weather.app.api.response


import com.fasterxml.jackson.annotation.JsonProperty

data class ForecastWeatherJson(@JsonProperty("city")
                               val city: City,
                               @JsonProperty("cnt")
                               val cnt: Int = 0,
                               @JsonProperty("cod")
                               val cod: String = "",
                               @JsonProperty("message")
                               val message: Double = 0.0,
                               @JsonProperty("list")
                               val list: List<ListItemJson>?)


data class Snow(@JsonProperty("3h") val snow: Double?)

data class City(@JsonProperty("country")
                val country: String = "",
                @JsonProperty("coord")
                val coord: CoordJson,
                @JsonProperty("name")
                val name: String = "",
                @JsonProperty("id")
                val id: Int = 0,
                @JsonProperty("population") val population: Int?)


data class ListItemJson(@JsonProperty("dt")
                        val dt: Int = 0,
                        @JsonProperty("dt_txt")
                        val dtTxt: String = "",
                        @JsonProperty("snow")
                        val snow: Snow?,
                        @JsonProperty("weather")
                        val weather: List<WeatherItemJson>?,
                        @JsonProperty("main")
                        val main: MainJson,
                        @JsonProperty("clouds")
                        val clouds: CloudsJson,
                        @JsonProperty("sys")
                        val sys: SysJson,
                        @JsonProperty("wind")
                        val wind: WindJson,
                        @JsonProperty("rain") val rain: Snow?)