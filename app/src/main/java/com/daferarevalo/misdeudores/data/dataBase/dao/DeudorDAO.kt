package com.daferarevalo.misdeudores.data.dataBase.dao

import androidx.room.*
import com.daferarevalo.misdeudores.data.dataBase.entities.Deudor

@Dao
interface DeudorDAO {
    @Insert
    fun insertDeudor(deudor: Deudor)

    @Query("SELECT * FROM tabla_deudor WHERE nombre LIKE :nombre")
    fun searchDeudor(nombre: String): Deudor

    @Delete
    fun deleteDeudor(deudor: Deudor)

    @Update
    fun updateDeudor(deudor: Deudor)

    @Query("SELECT * FROM tabla_deudor")
    fun getDeudores(): MutableList<Deudor>
}