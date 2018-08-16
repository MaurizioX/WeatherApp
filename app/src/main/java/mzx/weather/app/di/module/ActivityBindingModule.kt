package mzx.weather.app.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mzx.weather.app.di.ActivityScope
import mzx.weather.app.ui.main.MainViewModule
import mzx.weather.app.ui.main.MainWeatherActivity

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainViewModule::class, ViewModelFactoryModule::class])
    internal abstract fun mainActivity(): MainWeatherActivity
}