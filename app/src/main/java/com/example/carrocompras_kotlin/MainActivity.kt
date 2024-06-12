package com.example.carrocompras_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrocompras_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdaptadorProducto

    var listaProductos = ArrayList<Producto>()
    var carroCompras = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        setContentView(R.layout.login)

        val log1 = findViewById<Button>(R.id.logear)




        log1.setOnClickListener {

            setContentView(binding.root)

            agregarProductos()

            setupRecyclerView()



            val crear = findViewById<Button>(R.id.crearproductobtn)

                crear.setOnClickListener {
                    setContentView(R.layout.crear_producto)


                    val spinnerSpecialties = findViewById<Spinner>(R.id.categoriatxt)

                    val opcioncategoria = arrayOf("opcion1","opcion2")
                    spinnerSpecialties.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcioncategoria)



                }

        }














    }

    fun setupRecyclerView() {
        binding.rvListaProductos.layoutManager = LinearLayoutManager(this)
        adapter = AdaptadorProducto(this, binding.tvCantProductos, binding.btnVerCarro, listaProductos, carroCompras)
        binding.rvListaProductos.adapter = adapter
    }

    fun agregarProductos() {
        listaProductos.add(Producto("1", "Producto 1", "Descripcion del Producto 1", 50.0))
        listaProductos.add(Producto("2", "Producto 2", "Descripcion del Producto 2", 80.0))
        listaProductos.add(Producto("3", "Producto 3", "Descripcion del Producto 3", 40.0))
        listaProductos.add(Producto("4", "Producto 4", "Descripcion del Producto 4", 20.0))
        listaProductos.add(Producto("5", "Producto 5", "Descripcion del Producto 5", 56.0))
    }
}