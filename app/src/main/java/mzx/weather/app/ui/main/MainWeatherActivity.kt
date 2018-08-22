package mzx.weather.app.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.florent37.kotlin.pleaseanimate.please
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import mzx.weather.app.R
import mzx.weather.app.databinding.ActivityMainBinding
import mzx.weather.app.uidata.*
import mzx.weather.domain.element.WeatherElement
import javax.inject.Inject

class MainWeatherActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        val weatherViewModel =
                ViewModelProviders.of(this, viewModelFactory)[MainWeatherViewModel::class.java]
        val databind = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        databind.viewModel = weatherViewModel
        databind.setLifecycleOwner(this)
        please(duration = 1000) {
            animate(temperature) toBe {
                bottomOfItsParent(margin = 36f)
                leftOfItsParent(marginDp = 16f)
                visible()
//                width(40, keepRatio = true, toDp = true)
            }
        }.start()
        weatherViewModel.weatherLiveData.observe(this, Observer { updateChanges(it) })

    }

    private fun updateChanges(dataUI: DataUI?) {
        dataUI?.let {
            when (it) {
                is ErrorData -> {
                }
                is Initial -> {
                }
                is Loading -> {
                }
                is Response<*> -> {
                    val weatherElement = it.respponse as WeatherElement
                    temperature.text = weatherElement.main.temp.toString()
                }
//                is Response<WeatherElement> ->
            }
        }
    }
}
