package com.feluts.cryptostats.model

import com.google.gson.annotations.SerializedName

data class stats (
    @SerializedName("total") val totalCoins: Int,
    @SerializedName("totalMarketCap") val totalMCap: String,
    @SerializedName("total24hVolume") val total24hVol: String
        )