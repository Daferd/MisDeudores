package com.daferarevalo.misdeudores

import android.app.Application
import androidx.room.Room
import com.daferarevalo.misdeudores.data.dataBase.DeudorDataBase

class MisDeudores : Application() {
    companion object {
        lateinit var database: DeudorDataBase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            DeudorDataBase::class.java,
            "deudor_DB"
        ).allowMainThreadQueries()
            .build()
    }
}