package mzx.weather.app.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import mzx.weather.app.uidata.DataUI
import mzx.weather.app.uidata.Initial
import mzx.weather.app.uidata.Response
import mzx.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class MainWeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel() {
    private val _weatherLiveData = MutableLiveData<DataUI>().apply { value = Initial }
    val weatherLiveData: LiveData<DataUI> = _weatherLiveData

    private val _forecastLiveData = MutableLiveData<DataUI>().apply { value = Initial }
    val forecastLiveData: LiveData<DataUI> = _forecastLiveData

    init {
        val job = launch {
            withContext(UI) {
                _weatherLiveData.value = Response(weatherRepository.getWeather("Cordoba,AR"))
            }
            withContext(UI) {
                val element = weatherRepository.getForecast("Cordoba,AR")
                _forecastLiveData.value = Response(element)
            }
        }

    }

}
