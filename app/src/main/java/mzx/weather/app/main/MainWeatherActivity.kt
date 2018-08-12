package mzx.weather.app.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import mzx.weather.app.R
import javax.inject.Inject

class MainWeatherActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val weatherViewModel = viewModelFactory.create(MainWeatherViewModel::class.java)
        setContentView(R.layout.activity_main)
        weatherViewModel.getWheatherData()
    }
}
