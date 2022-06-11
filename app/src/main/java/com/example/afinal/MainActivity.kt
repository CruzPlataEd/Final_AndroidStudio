package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.afinal.databinding.ActivityMainBinding
import com.example.afinal.model.Numeros
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    //Creamos la variable afuera para poder utilizarla en las demás funciones
    //private lateinit var binding: ActivityMainBinding
    private lateinit var etNumero: EditText
    private lateinit var spinner: Spinner
    private lateinit var datos: ArrayList<Int>
    var eleccion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datos = ArrayList()
        spinner = findViewById(R.id.spinner)
        val languages = resources.getStringArray(R.array.Opciones)

        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity, getString(R.string.seleccion) + languages[position], Toast.LENGTH_SHORT).show()
                    if(position==0){
                        //Selección mayor a menor
                        eleccion = 0
                    }
                    if(position==1){
                        //Selección menor a mayor
                        eleccion = 1
                    }

                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                    Toast.makeText(this@MainActivity, getString(R.string.noSeleccion),Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun ordenar(view: View) {
        etNumero = findViewById(R.id.etNumero)

        when(view?.id){
            R.id.buttonAgregar->{
                if(!etNumero.text.toString().isEmpty()){
                    val numero = etNumero.text.toString().toInt()
                    datos.add(numero)
                    Toast.makeText(this,getString(R.string.agregado),Toast.LENGTH_SHORT).show()
                }else{
                    //Con lo de abajo el error se mostrará en la parte donde se escribe el número
                    etNumero.error = getString(R.string.errorNumero)
                    etNumero.requestFocus()
                }
            }
            R.id.button2->{
                val intent = Intent(this, MainActivity2::class.java)
                val parametros = Bundle()
                parametros.putIntegerArrayList("numeros",datos)
                parametros.putInt("eleccion",eleccion)
                intent.putExtras(parametros)
                startActivity(intent)
            }
        }

    }
}