package mzx.weather.app.di.module

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import mzx.weather.app.EnvironmentImpl
import mzx.weather.app.api.WeatherApiImpl
import mzx.weather.app.api.WeatherApiRetrofit
import mzx.weather.app.config.Environment
import mzx.weather.app.repository.WeatherRepositoryImpl
import mzx.weather.data.api.WeatherApi
import mzx.weather.domain.repository.WeatherRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton


@Module
class WeatherModule {

    @Provides
    fun providerOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build()

    @Provides
    @Singleton
    fun providesWeatherApiRetrofit(environment: Environment, okHttpClient: OkHttpClient): WeatherApiRetrofit =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(environment.serverUrl)
                    .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper()))
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
                    .create(WeatherApiRetrofit::class.java)

    @Provides
    @Singleton
    fun providesWeatherApi(weatherApiImpl: WeatherApiImpl): WeatherApi = weatherApiImpl

    @Provides
    @Singleton
    fun providesWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl)
            : WeatherRepository = weatherRepositoryImpl


    @Provides
    @Singleton
    fun providesEnvironment(environmentImpl: EnvironmentImpl): Environment = environmentImpl

}