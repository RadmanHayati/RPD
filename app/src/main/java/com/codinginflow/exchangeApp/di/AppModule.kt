package com.codinginflow.exchangeApp.di

import com.codinginflow.exchangeApp.data.remote.ExchangeApi
import com.codinginflow.exchangeApp.repository.ExchangeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideExchangeRepository(
        api: ExchangeApi
    ) = ExchangeRepository(api = api)

    @Provides
    @Singleton
    fun provideExchangeApi(): ExchangeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.coingecko.com/api/v3/coins/")
            .build()
            .create(ExchangeApi::class.java)
    }

}