package com.feluts.cryptostats.api

import com.feluts.cryptostats.model.Coins
import com.feluts.cryptostats.model.Respuesta
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiGecko {

    @GET("coins")
    @Headers("Accept: application/json")
    suspend fun getCoins(
        @Query("api_key") apiKey:String = ""
    ): Call<Respuesta>
}