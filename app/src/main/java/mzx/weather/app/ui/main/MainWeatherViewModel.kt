package mzx.weather.app.ui.main

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
    val weatherLiveData = MutableLiveData<DataUI>().apply { value = Initial }

    init {
        val job = launch {
            val asd = withContext(UI) {
                weatherLiveData.value = Response(weatherRepository.getWeather("LONDON"))
            }
        }

    }

}
