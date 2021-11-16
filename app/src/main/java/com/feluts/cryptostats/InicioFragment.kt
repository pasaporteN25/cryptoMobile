package com.feluts.cryptostats

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feluts.cryptostats.databinding.InicioFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InicioFragment : Fragment() {

    companion object {
        fun newInstance() = InicioFragment()
    }

    private lateinit var InicioVM: InicioViewModel
    private var _binding: InicioFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = InicioFragmentBinding.inflate(inflater, container, false)
        InicioVM = ViewModelProvider(this).get(InicioViewModel::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            val monedas = InicioVM.getAllCoins()
            binding.nameTxt.text = monedas[0].name
            binding.priceTxt.text = monedas[0].precio

        }





        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        InicioVM = ViewModelProvider(this).get(InicioViewModel::class.java)




    }

}