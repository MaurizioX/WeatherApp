package mzx.weather.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import mzx.weather.app.di.module.ActivityBindingModule
import mzx.weather.app.di.module.AppModule
import mzx.weather.app.di.module.WeatherModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBindingModule::class,
    AppModule::class, WeatherModule::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}

