package mzx.weather.app.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import mzx.weather.app.DaggerViewModelFactory

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}