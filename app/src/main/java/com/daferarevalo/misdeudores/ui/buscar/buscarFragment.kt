package com.daferarevalo.misdeudores.ui.buscar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.daferarevalo.misdeudores.MisDeudores
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.data.dataBase.dao.DeudorDAO
import com.daferarevalo.misdeudores.databinding.FragmentBuscarBinding

class buscarFragment : Fragment() {

    private lateinit var binding: FragmentBuscarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentBuscarBinding.bind(view)


        binding.buscarButton.setOnClickListener {
            val nombre = binding.nombreBuscarEditText.text.toString()

            val deudorDAO: DeudorDAO = MisDeudores.database.DeudorDAO()
            val deudor = deudorDAO.searchDeudor(nombre)

            if (deudor != null) {
                binding.telefonoTextView.text = deudor.telefono
                binding.ValorDeudaTextView.text = deudor.deuda.toString()
            } else {
                Toast.makeText(context, "No Existe", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {

    }
}