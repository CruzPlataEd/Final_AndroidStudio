package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.afinal.databinding.ActivityMain2Binding
import com.example.afinal.model.Numeros

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val parametros = intent.extras
        val datos = parametros?.getIntegerArrayList("numeros")
        val eleccion = parametros?.getInt("eleccion")

        val numeros = ArrayList<Numeros>()
        val rango = datos?.size
        var aux = 0

        if(eleccion==0) {
            for (x in 0 until rango!!) {
                for (y in 0 until rango!!) {
                    if (datos[x] > datos[y]) {
                        aux = datos[y]
                        datos[y] = datos[x]
                        datos[x] = aux
                    }
                }
            }
        }
        if(eleccion==1) {
            for (x in 0 until rango!!) {
                for (y in 0 until rango!!) {
                    if (datos[x] < datos[y]) {
                        aux = datos[y]
                        datos[y] = datos[x]
                        datos[x] = aux
                    }
                }
            }
        }
        if (datos == null) {
            Toast.makeText(this,"Esta vacia la lista",Toast.LENGTH_LONG).show()
        }

        for(i in 0 until rango!!){
            val num = Numeros(i.toLong(),i,datos[i])
            numeros.add(num)
        }

        binding.lv.adapter = Adaptador(this,numeros)

    }
}