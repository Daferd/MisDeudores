package com.daferarevalo.misdeudores.ui.actualizar

//import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.daferarevalo.misdeudores.MisDeudores
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.data.dataBase.entities.Deudor
import com.daferarevalo.misdeudores.databinding.FragmentActualizarBinding

class ActualizarFragment : Fragment() {

    private lateinit var binding: FragmentActualizarBinding
    private var isSearching = true
    private var idDeudor = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actualizar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentActualizarBinding.bind(view)
        binding.modificarButton.setOnClickListener {
            val nombre = binding.nombreBuscarEditText.text.toString()
            val telefono = binding.telefonoEditText.text.toString()
            val valor = binding.valorEditText.text.toString()

            val deudorDAO = MisDeudores.database.DeudorDAO()
            val deudor = deudorDAO.searchDeudor(nombre)

            if (isSearching) { //buscando
                val deudor = deudorDAO.searchDeudor(nombre)
                if (deudor != null) {
                    isSearching = false
                    binding.modificarButton.text = getString(R.string.actualizar)
                    idDeudor = deudor.id
                    binding.telefonoEditText.setText(deudor.telefono)
                    binding.valorEditText.setText(deudor.deuda?.toString())
                } else {
                    Toast.makeText(context, "No existe", Toast.LENGTH_SHORT).show()
                }
            } else { //actualizando
                val deudor = Deudor(idDeudor, nombre, telefono, valor.toLong())

                deudorDAO.updateDeudor(deudor)
                isSearching = true
                binding.modificarButton.text = getString(R.string.buscar)
                Toast.makeText(context, "Actualizado", Toast.LENGTH_SHORT).show()
            }

        }


    }

    companion object
}