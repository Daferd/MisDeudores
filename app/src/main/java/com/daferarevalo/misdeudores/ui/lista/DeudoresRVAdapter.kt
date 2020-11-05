package com.daferarevalo.misdeudores.ui.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.data.dataBase.entities.Deudor
import com.daferarevalo.misdeudores.databinding.DeudoresItemBinding

class DeudoresRVAdapter(var deudoresList: ArrayList<Deudor>) :
    RecyclerView.Adapter<DeudoresRVAdapter.DeudoresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeudoresViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.deudores_item, parent, false)
        return DeudoresViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DeudoresViewHolder, position: Int) {
        val deudor = deudoresList[position]
        holder.bindDeudor(deudor)
    }

    override fun getItemCount(): Int {
        return deudoresList.size
    }

    class DeudoresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = DeudoresItemBinding.bind(itemView)
        fun bindDeudor(deudor: Deudor) {
            binding.nombreTextView.text = deudor.nombre.toString()
            binding.valorTextView.text = deudor.deuda.toString()
        }
    }
}
