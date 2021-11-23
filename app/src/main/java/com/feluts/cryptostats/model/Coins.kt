package com.feluts.cryptostats.model

import com.google.gson.annotations.SerializedName

data class Coins (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("market_data") val precio: ArrayList<ArrayList<Precio>>,
    @SerializedName("market_cap") val mcap: ArrayList<ArrayList<Precio>>,
    @SerializedName("total_volume") val volumen: ArrayList<ArrayList<Precio>>
        )