package mzx.weather.app.ui.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mzx.weather.app.di.ViewModelKey

@Module
abstract class MainViewModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainWeatherViewModel::class)
    abstract fun bindMyViewModel(myViewModel: MainWeatherViewModel): ViewModel

}