package com.daferarevalo.misdeudores.ui.lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daferarevalo.misdeudores.MisDeudores
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.data.dataBase.entities.Deudor
import com.daferarevalo.misdeudores.databinding.FragmentListaBinding


class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    val listDeudores: List<Deudor> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentListaBinding.bind(view)

        binding.deudoresRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.deudoresRecyclerView.setHasFixedSize(true)
        val deudoresRVAdapter = DeudoresRVAdapter(listDeudores as ArrayList<Deudor>)

        binding.deudoresRecyclerView.adapter = deudoresRVAdapter

        val deudorDAO = MisDeudores.database.DeudorDAO()
        val listDeudores = deudorDAO.getDeudores()

        deudoresRVAdapter.notifyDataSetChanged()
    }
}