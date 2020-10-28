package com.daferarevalo.misdeudores.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daferarevalo.misdeudores.data.dataBase.dao.DeudorDAO
import com.daferarevalo.misdeudores.data.dataBase.entities.Deudor

@Database(entities = [Deudor::class], version = 1)
abstract class DeudorDataBase : RoomDatabase() {

    abstract fun DeudorDAO(): DeudorDAO
}