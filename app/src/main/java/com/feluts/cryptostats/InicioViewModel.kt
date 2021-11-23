package com.feluts.cryptostats

import android.util.Log
import androidx.lifecycle.ViewModel
import com.feluts.cryptostats.api.ApiBNB
import com.feluts.cryptostats.api.ApiBNBImp
import com.feluts.cryptostats.api.ApiGeckoImp
import com.feluts.cryptostats.model.CoinData
import com.feluts.cryptostats.model.Coins
import com.feluts.cryptostats.model.Respuesta
import com.feluts.cryptostats.model.Welcome
import retrofit2.Call
import retrofit2.awaitResponse

class InicioViewModel : ViewModel() {

    val listaCoins = ArrayList<CoinData>()

    fun getCrypto(): Call<Welcome>{
        val api = ApiBNBImp()
        return api.getAllCrypto()
    }

    suspend fun getAllCoins(): ArrayList<CoinData>{
        Log.d("iniciovm inicio: ","hasta aca si")
        //aca rompe, deberia probar el enqueque
        val resp = getCrypto().awaitResponse()
        if (resp.isSuccessful){
            val data = resp.body()

            if(data!=null){
                Log.d("InicioVM dice: ", data.status)
                //Log.d("InicioVM dice: ", data.data)
                //Log.d("InicioVM dice: ", data.toString())


                for(coin in data.data.monedas){
                    //Log.d("Data:",coin.name)
                    listaCoins.add(
                        CoinData(coin.status, coin.simbolo
                            ,coin.name, coin.icono
                            ,coin.MCap, coin.precio
                            ,coin.cambio, coin.url
                            ,coin.vol24h, coin.precioenBtc
                        )
                    )
                }
            }
        }else{
            Log.d("IVM resp: ",resp.errorBody().toString())
        }
        return listaCoins
    }


    //coingecko test
//
//    val lista = ArrayList<Coins>()
//
//    suspend fun getCoins():List<Coins>{
//        val api = ApiGeckoImp()
//        return api.getAllCoins()
//    }
//
//    suspend fun getAllCoins():List<Coins>{
//        return getCoins()
//    }


}