package com.feluts.cryptostats.model

import com.google.gson.annotations.SerializedName

data class Precio(
    @SerializedName("usd") val usd:Int
)