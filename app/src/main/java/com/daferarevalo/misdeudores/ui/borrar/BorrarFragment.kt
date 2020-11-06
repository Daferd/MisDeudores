package com.daferarevalo.misdeudores.ui.borrar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.daferarevalo.misdeudores.MisDeudores
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.data.dataBase.dao.DeudorDAO
import com.daferarevalo.misdeudores.databinding.FragmentBorrarBinding
import kotlinx.android.synthetic.main.fragment_borrar.*


class BorrarFragment : Fragment() {

    private lateinit var binding: FragmentBorrarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_borrar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentBorrarBinding.bind(view)

        binding.borrarButton.setOnClickListener {
            val nombre = binding.nombreBorrarEditText.text.toString()

            if (nombre.isBlank() || nombre.isEmpty()) {
                nombreBorrarEditTextLayout.error = getString(R.string.ingreseNombre)
            } else {
                nombreBorrarEditTextLayout.error = null
                val deudorDAO: DeudorDAO = MisDeudores.database.DeudorDAO()
                val deudor = deudorDAO.searchDeudor(nombre)

                if (deudor != null) {
                    deudorDAO.deleteDeudor(deudor)
                    Toast.makeText(context, "Borrado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "No Existe", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object
}