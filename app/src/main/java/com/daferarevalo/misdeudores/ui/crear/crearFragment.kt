package com.daferarevalo.misdeudores.ui.crear

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.daferarevalo.misdeudores.MisDeudores
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.data.dataBase.dao.DeudorDAO
import com.daferarevalo.misdeudores.data.dataBase.entities.Deudor
import com.daferarevalo.misdeudores.databinding.FragmentCrearBinding
import kotlinx.android.synthetic.main.fragment_crear.*
import java.sql.Types.NULL


class crearFragment : Fragment() {

    private lateinit var binding: FragmentCrearBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentCrearBinding.bind(view)

        guardarButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val telefono = telefonoEditText.text.toString()
            val valor = valorDeudaEditText.text.toString().toLong()

            val deudor = Deudor(NULL, nombre, telefono, valor)
            //Log.d("nombre",deudor.nombre)
            val deudorDAO: DeudorDAO = MisDeudores.database.DeudorDAO()

            deudorDAO.insertDeudor(deudor)
            Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show()
        }
    }

}