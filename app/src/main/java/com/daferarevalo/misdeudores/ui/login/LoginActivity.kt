package com.daferarevalo.misdeudores.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daferarevalo.misdeudores.MisDeudores
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.data.dataBase.dao.UsuarioDAO
import com.daferarevalo.misdeudores.ui.bottom.BottomActivity
import com.daferarevalo.misdeudores.ui.registro.RegistroActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    companion object {
        private val TAG = RegistroActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        iniciar_sesion_button.setOnClickListener {

            val correoLogin = correo_login_edit_text.text.toString()
            val contrasenaLogin = contrasena_login_edit_text.text.toString()
            //loginWihtFirebase(correoLogin,contrasenaLogin)

            if (correoLogin.isEmpty() || correoLogin.isBlank()) {
                correo_login_edit_text_layout.error = getString(R.string.ingreseCorreo)
            } else if (contrasenaLogin.isEmpty() || contrasenaLogin.isBlank()) {
                correo_login_edit_text_layout.error = null
                contrasena_login_edit_text_layout.error = getString(R.string.ingreseContrasena)
            } else {
                correo_login_edit_text_layout.error = null
                contrasena_login_edit_text_layout.error = null
                val usuarioDAO: UsuarioDAO = MisDeudores.dataBase1.UsuarioDAO()
                val correoUsuario = usuarioDAO.searchCorreo(correoLogin)
                val contrasenaUsuario = usuarioDAO.searchContrasena(contrasenaLogin)
                //val usuario = usuarioDAO.getAll()
                //val correoU = usuario[0].correo.toString()

                if (correoUsuario == null) {
                    Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_SHORT).show()
                } else if (contrasenaUsuario == null) {
                    Toast.makeText(this, "contrasena no coincide", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, BottomActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        registrar_login_button.setOnClickListener {
            goToRegistroActivity()
        }
    }

    private fun loginWihtFirebase(correo: String, contrasena: String) {
        auth.signInWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    //val user = auth.currentUser
                    goToBottomActivity()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun goToBottomActivity() {
        val intent = Intent(this, BottomActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goToRegistroActivity() {
        val intent = Intent(this, RegistroActivity::class.java)
        //intent.putExtra("numero", 1)
        startActivity(intent)
        finish()
    }
}