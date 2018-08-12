package mzx.weather.app

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    private val injector: AppComponent by lazy(this) {
        DaggerAppComponent.builder().create(this) as AppComponent
    }
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector


    override fun onCreate() {
        super.onCreate()
        injector.inject(this)
    }
}