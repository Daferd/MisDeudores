package com.daferarevalo.misdeudores.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.daferarevalo.misdeudores.data.dataBase.entities.Usuario

@Dao
interface UsuarioDAO {
    @Insert
    fun insertUsuario(usuario: Usuario)

    @Query("SELECT * FROM tabla_usuario")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM tabla_usuario WHERE correo LIKE :correo")
    fun searchCorreo(correo: String): Usuario

    @Query("SELECT * FROM tabla_usuario WHERE contrasena LIKE:contrasena")
    fun searchContrasena(contrasena: String): Usuario
}