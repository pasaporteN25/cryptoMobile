package com.feluts.cryptostats.rv

//import com.ahmadrosid.svgloader.SvgDecoder
//import com.ahmadrosid.svgloader.SvgLoader
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.feluts.cryptostats.R
import com.feluts.cryptostats.model.CoinData
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CoinAdapter(private var monedas: ArrayList<CoinData>,val actv: Fragment): RecyclerView.Adapter<CoinAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val icono: ImageView
        val nombre: TextView
        val variac: TextView
        val precio: TextView

        init {
            icono = view.findViewById(R.id.icon_img)
            nombre = view.findViewById(R.id.nombre_txt)
            variac = view.findViewById(R.id.variac_txt)
            precio = view.findViewById(R.id.precio_txt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.monedas_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.setText(monedas[position].name)
        holder.variac.setText(monedas[position].cambio)
        val x = monedas[position].precio.toDouble().toInt()
        holder.precio.setText(x.toString())
        holder.itemView.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(holder.icono.context,monedas[position].icono,Toast.LENGTH_SHORT).show()
            }
        )
        try {
            if(monedas[position].icono.contains("png",false)){
                holder.icono.load(monedas[position].icono)
            }else{
                GlideToVectorYou.init().with(holder.icono.context)
                    .setPlaceHolder(R.mipmap.ic_launcher,R.mipmap.ic_launcher)
                    .load(monedas[position].icono.toUri(),holder.icono)
            }



//            monedas[position].icono.let {
//                if(it.toLowerCase(Locale.ENGLISH).endsWith("svg")){
//                    val imageLoader = ImageLoader.Builder(actv.requireContext())
//                        .componentRegistry {
//                            add(SvgDecoder(actv.requireContext()))
//                        }.build()
//                    val req = LoadRequest.Builder
//                }
//            }


//            val imgLoader = ImageLoader.Builder(holder.icono.context)
//                .componentRegistry {
//                    add(SvgDecoder(holder.icono.context))
//                }.build()
//
//            holder.icono.(
//                    data = monedas[position].icono,
//            builder ={
//                Decoder(SvgDecoder(holder.icono.context))
//            }
//            )

        }catch (e: Exception){
            Log.e("Coil: ","Error al cargar",e)
        }

//        if(monedas[position].icono.toString().contains("png",false)){

//            try {
//                Glide.with(holder.icono.context).load(monedas[position].icono)
//                    .centerCrop().into(holder.icono)
//            }catch (e: Exception){
//                Log.e("IMG Glide: ","Fallo al cargar",e)
//            }
//        }else{
//            try {
//                SvgLoader.pluck().with(actv.parent).setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
//                    .load(monedas[position].icono,holder.icono)
//
//            }catch (e: Exception){
//                Log.e("IMG svg: ","Fallo al cargar",e)
//            }
//        }

    }

    override fun getItemCount(): Int {
        return monedas.size
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


}