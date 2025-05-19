package com.torch.cryptotracker.data.api

import com.torch.cryptotracker.data.model.CoinDto
import retrofit2.http.GET
import retrofit2.http.Query


interface CryptoService {

    @GET("coins/markets")
    suspend fun getCryptoList(
        @Query("vs_currency") vsCurrency: String = "usd",
        @Query("order") order: String = "market_cap_desc"
    ): List<CoinDto>
}