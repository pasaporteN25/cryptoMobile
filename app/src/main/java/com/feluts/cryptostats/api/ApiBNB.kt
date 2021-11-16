package com.feluts.cryptostats.api

import com.feluts.cryptostats.model.Respuesta
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiBNB {

    @GET("coins")
    @Headers("Accept: application/json")
    fun getAllCrypto(
        @Query("api_key") apiKey:String = "coinranking1270bdc3b853e6339eaf3c4b21dfc36ba531b9b3fa7431c4"
    ): Call<Respuesta>

}