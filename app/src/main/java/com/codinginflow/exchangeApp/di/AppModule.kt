package com.codinginflow.exchangeApp.di

import com.codinginflow.exchangeApp.data.remote.ExchangeApi
import com.codinginflow.exchangeApp.repository.ExchangeRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    fun provideExchangeRepository(
        api: ExchangeApi
    ) = ExchangeRepository(api = api)

    fun provideExchangeApi(): ExchangeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("sth.com")
            .build()
            .create(ExchangeApi::class.java)
    }

}