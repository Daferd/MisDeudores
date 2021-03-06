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
import java.util.*

class ListaFragment : Fragment() {
    private lateinit var binding: FragmentListaBinding
    private lateinit var deudoresRVAdapter: DeudoresRVAdapter
    var listDeudores: MutableList<Deudor> = mutableListOf()

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

        val deudorDAO = MisDeudores.database.DeudorDAO()
        listDeudores = deudorDAO.getDeudores()

        deudoresRVAdapter = DeudoresRVAdapter(listDeudores as ArrayList<Deudor>)
        binding.deudoresRecyclerView.adapter = deudoresRVAdapter

        //cargarDesdeDatabase()
        //cargarDesdeFaribase()

        deudoresRVAdapter.notifyDataSetChanged()

    }
    /*
    private fun cargarDesdeFaribase() {
        val database = FirebaseDatabase.getInstance()
        val myDeudoresRef= database.getReference("deudores")
        listDeudores.clear()

        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dato: DataSnapshot in snapshot.children){
                    val deudorServer = dato.getValue(DeudorServer::class.java)
                    deudorServer?.let {
                        listDeudores.add(it) }
                }
                deudoresRVAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        myDeudoresRef.addValueEventListener(postListener)
    }*/


    private fun cargarDesdeDatabase() {
        val deudorDAO = MisDeudores.database.DeudorDAO()
        listDeudores = deudorDAO.getDeudores()
    }
}