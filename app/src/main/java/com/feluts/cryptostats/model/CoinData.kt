package com.feluts.cryptostats.model

import com.google.gson.annotations.SerializedName

data class CoinData (
    @SerializedName("uuid") val status: String,
    @SerializedName("symbol") val simbolo: String,
    @SerializedName("name") val name: String,
    @SerializedName("iconUrl") val icono: String,
    @SerializedName("marketCap") val MCap: String,
    @SerializedName("price") val precio: String,
    @SerializedName("change") val cambio: String,
    @SerializedName("coinrankingUrl") val url: String,
    @SerializedName("24hVolume") val vol24h: String,
    @SerializedName("btcPrice") val precioenBtc: String
        )