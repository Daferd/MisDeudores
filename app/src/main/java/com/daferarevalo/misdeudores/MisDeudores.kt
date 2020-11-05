package com.daferarevalo.misdeudores

import android.app.Application
import androidx.room.Room
import com.daferarevalo.misdeudores.data.dataBase.DeudorDataBase
import com.daferarevalo.misdeudores.data.dataBase.UsuarioDataBase

class MisDeudores : Application() {
    companion object {
        lateinit var database: DeudorDataBase
        lateinit var dataBase1: UsuarioDataBase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            DeudorDataBase::class.java,
            "deudor_DB"
        ).allowMainThreadQueries()
            .build()

        dataBase1 = Room.databaseBuilder(
            this,
            UsuarioDataBase::class.java,
            "usuario_DB"
        ).allowMainThreadQueries()
            .build()
    }
}