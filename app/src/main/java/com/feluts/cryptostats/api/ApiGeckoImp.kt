package com.feluts.cryptostats.api

import com.feluts.cryptostats.model.Coins
import com.feluts.cryptostats.model.Respuesta
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiGeckoImp {
    //api.coingecko.com/api/v3

    private fun getRetrofit(): Retrofit{
        val ret = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.coingecko.com/api/v3/").build()
        return ret
    }

//    suspend fun getAllCoins(): List<Coins>{
//        val resp = getRetrofit().create(ApiGecko::class.java).getCoins()
//        return resp
//    }

}