package com.feluts.cryptostats.model

import com.google.gson.annotations.SerializedName

data class Data (
        @SerializedName("stats") val info: Stats,
        @SerializedName("coins") val monedas: ArrayList<CoinData>
        )