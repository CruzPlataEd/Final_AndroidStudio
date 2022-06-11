package com.example.afinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.afinal.databinding.ElementoListaBinding
import com.example.afinal.model.Numeros

class Adaptador(private val contexto: Context, val datos: ArrayList<Numeros>): BaseAdapter(){

    private val inflater: LayoutInflater = LayoutInflater.from(contexto)

    //Cuantos elementos se verá en pantalla
    override fun getCount(): Int {
        return datos.size
    }

    //Acceder a un elemento en la lista
    override fun getItem(position: Int): Any {
        return datos[position]
    }
    //Elemento en la posicion x (obtener el ID)
    override fun getItemId(p0: Int): Long {
        return datos[p0].id
    }
    //Generar la vista de cada elemento
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ElementoListaBinding.inflate(inflater)

        with(binding){
            tvPos.text = datos[p0].pos.toString()
            tvNum.text = datos[p0].num.toString()
        }
        return binding.root
    }

}