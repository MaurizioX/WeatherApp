package mzx.weather.app

import mzx.weather.app.config.Environment
import javax.inject.Inject

class EnvironmentImpl @Inject constructor() : Environment {
    override val unit: String
        get() = "metric"
    override val serverUrl: String
        get() = "https://api.openweathermap.org"
    override val apiKey: String
        get() = "e35ab8a5096894e3f8e08411b6d97b46"
}