package com.feluts.cryptostats.api

import android.util.Log
import com.feluts.cryptostats.model.Respuesta
import com.feluts.cryptostats.model.Welcome
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiBNBImp {

    private fun getRetrofit(): Retrofit{
        Log.d("ApiIMP dice:", "aca sigo")
        val resp = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.coinranking.com/v2/").build()

        Log.d("ApiIMP dice:", "aca rompio")

        return resp
    }

    fun getAllCrypto(): Call<Welcome>{
        val resp =  getRetrofit().create(ApiBNB::class.java).getAllCrypto()
        Log.d("ApiIMP2 dice:", "aca sigo")
        return resp
    }
}