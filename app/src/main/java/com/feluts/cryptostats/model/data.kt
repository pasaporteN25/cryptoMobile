package com.feluts.cryptostats.model

import com.google.gson.annotations.SerializedName

data class data (
        @SerializedName("stats") val info: ArrayList<stats>,
        @SerializedName("coins") val monedas: ArrayList<CoinData>
        )