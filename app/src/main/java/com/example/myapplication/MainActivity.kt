package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val listViewProdutos = findViewById<ListView>(R.id.listViewProdutos)


        listViewProdutos.adapter = produtosAdapter

        val btnInserir = findViewById<Button>(R.id.btnInserir)
        btnInserir.setOnClickListener {

            val txtProduto = findViewById<TextView>(R.id.txtProduto)
            val produto = txtProduto.text.toString()
            if(produto.isNotEmpty()){
                produtosAdapter.add(produto)
                //txtProduto.text.clear()
            } else{
                txtProduto.error = "Coloque um Produto"
            }

        }

        listViewProdutos.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)

        }
    }
}




