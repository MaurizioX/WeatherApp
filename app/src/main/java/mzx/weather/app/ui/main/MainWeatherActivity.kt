package mzx.weather.app.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import mzx.weather.app.R
import mzx.weather.app.databinding.ActivityMainBinding
import javax.inject.Inject

class MainWeatherActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            viewModel = ViewModelProviders.of(this@MainWeatherActivity, viewModelFactory)[MainWeatherViewModel::class.java]
            setLifecycleOwner(this@MainWeatherActivity)
        }
    }
}
