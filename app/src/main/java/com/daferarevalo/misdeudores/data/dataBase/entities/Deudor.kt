package com.daferarevalo.misdeudores.data.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_deudor")
data class Deudor(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "nombre") val nombre: String? = null,
    @ColumnInfo(name = "telefono") val telefono: String? = null,
    @ColumnInfo(name = "valor") val deuda: Long? = null
)