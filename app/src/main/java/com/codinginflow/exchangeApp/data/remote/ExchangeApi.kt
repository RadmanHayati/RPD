package com.codinginflow.exchangeApp.data.remote

import com.codinginflow.exchangeApp.data.remote.response.Currency
import com.codinginflow.exchangeApp.data.remote.response.History
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ExchangeApi {

    @GET("currency")
    suspend fun getCurrenciesList(): Currency

    @GET("{name}/market_chart?")
    suspend fun getCurrencyInfo(
        @Path("name") name: String,
        @Query("vs_currency") currency: String = "usd",
        @Query("days") days: String = "2",
        @Query("interval") interval: String = "daily",
        ): History
}