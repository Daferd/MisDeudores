package com.daferarevalo.misdeudores.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daferarevalo.misdeudores.data.dataBase.dao.UsuarioDAO
import com.daferarevalo.misdeudores.data.dataBase.entities.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDataBase : RoomDatabase() {
    abstract fun UsuarioDAO(): UsuarioDAO
}