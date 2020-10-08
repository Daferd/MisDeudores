package com.daferarevalo.misdeudores.ui.main


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.ui.buscar.buscarFragment
import com.daferarevalo.misdeudores.ui.crear.crearFragment


class MainActivity() : AppCompatActivity() {

    private val manager = supportFragmentManager
    private var transaction = manager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val creaFragment = crearFragment()
        transaction.add(R.id.contenedor, creaFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        transaction = manager.beginTransaction()
        when (item.itemId) {
            R.id.menu_crear -> {
                val creaFragment = crearFragment()
                transaction.replace(R.id.contenedor, creaFragment).commit()
            }
            R.id.menu_buscar -> {
                val buscaFragment = buscarFragment()
                transaction.replace(R.id.contenedor, buscaFragment).commit()

            }
        }
        return super.onOptionsItemSelected(item)
    }

}