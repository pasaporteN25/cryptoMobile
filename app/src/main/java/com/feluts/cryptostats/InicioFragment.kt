package com.feluts.cryptostats

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.feluts.cryptostats.databinding.InicioFragmentBinding
import com.feluts.cryptostats.rv.CoinAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InicioFragment : Fragment() {

    companion object {
        fun newInstance() = InicioFragment()
    }

    private lateinit var InicioVM: InicioViewModel

    //private lateinit var Coinsrv: RecyclerView
    private var _binding: InicioFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = InicioFragmentBinding.inflate(inflater, container, false)
        InicioVM = ViewModelProvider(this).get(InicioViewModel::class.java)
        val rvC = binding.inicioRv
        rvC.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        GlobalScope.launch(Dispatchers.IO) {
            val monedas = InicioVM.getAllCoins()
            //binding.nameTxt.text = monedas[0].name
            //binding.priceTxt.text = monedas[0].precio.toString()
            //Log.d("Digo: ",monedas[0].name+" = "+monedas[0].precio)
            //withContext()
            //pasar al RV
            //usar boton para cambiar de pestaña?

            withContext(Dispatchers.Main) {
                //binding.nameTxt.text = monedas[0].name
                //binding.priceTxt.text = monedas[0].precio.toString()
                binding.progressBar.visibility = View.INVISIBLE
                rvC.adapter = CoinAdapter(monedas, this@InicioFragment)
                Handler().postDelayed({
                    //                      rvC.adapter?.notifyDataSetChanged()
                }, 3000)


            }

//            Esto deberia recargar la data
//
//            Handler().postDelayed({
//                GlobalScope.launch(Dispatchers.IO) {
//
//                    withContext(Dispatchers.Main) {
//                        val monedas = InicioVM.getAllCoins()
//                        rvC.adapter = CoinAdapter(monedas, this@InicioFragment)
//                        rvC.adapter?.notifyDataSetChanged()
//
//                    }
//
//                }
//            }, 15000)


            //
            //CG API:
//            val coins = InicioVM.getAllCoins()
//            binding.nameTxt.text = coins[0].name
//            binding.priceTxt.text = coins[0].precio.toString()

        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        InicioVM = ViewModelProvider(this).get(InicioViewModel::class.java)


    }

}