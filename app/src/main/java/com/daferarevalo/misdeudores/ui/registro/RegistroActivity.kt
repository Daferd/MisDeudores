package com.daferarevalo.misdeudores.ui.registro

//import com.daferarevalo.misdeudores.databinding.ActivityRegistroBinding
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daferarevalo.misdeudores.MisDeudores
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.data.dataBase.dao.UsuarioDAO
import com.daferarevalo.misdeudores.data.dataBase.entities.Usuario
import com.daferarevalo.misdeudores.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*
import java.sql.Types.NULL

class RegistroActivity : AppCompatActivity() {

    //  private lateinit var biniding: ActivityRegistroBinding

    private lateinit var auth: FirebaseAuth

    companion object {
        //private const val EMPTY = " "
        //private const val SPACE = " "
        private val TAG = RegistroActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        auth = FirebaseAuth.getInstance()
        registrar_Button.setOnClickListener {

            val nombre = nombreEditText.text.toString()
            val correo = correoEditText.text.toString()
            val contrasena = contrasenaEditText.text.toString()
            //registroEnFirebase(correo,contrasena)
            //verificarCamposvacios(nombre,correo,contrasena)
            if (nombre.isEmpty() || nombre.isBlank()) {
                nombre_edit_text_layout.error = getString(R.string.ingreseNombre)
            } else if (correo.isEmpty() || correo.isBlank()) {
                nombre_edit_text_layout.error = null
                correo_edit_text_layout.error = getString(R.string.ingreseCorreo)
            } else if (contrasena.isEmpty() || contrasena.isBlank()) {
                nombre_edit_text_layout.error = null
                correo_edit_text_layout.error = null
                contrasena_edit_text_layout.error = getString(R.string.ingreseContrasena)
            } else {
                nombre_edit_text_layout.error = null
                correo_edit_text_layout.error = null
                contrasena_edit_text_layout.error = null
                val usuarioDAO: UsuarioDAO = MisDeudores.dataBase1.UsuarioDAO()
                val correoRegistro = usuarioDAO.searchCorreo(correo)
                if (correoRegistro != null) {
                    Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                } else {
                    val usuario = Usuario(NULL, nombre, correo, contrasena)
                    usuarioDAO.insertUsuario(usuario)
                    goToLoginActivity()
                }
            }
            /*
            val telefono = telefonoEditText.text.toString()
            val repContrasena = repContrasenaEditText.text.toString()
            val genero =
                if (masculinoRadioButton.isChecked) getString(R.string.masculino) else getString(
                    R.string.femenino
                )
            var pasatiempos = EMPTY

            if(nadarCheckBox.isChecked) pasatiempos = pasatiempos + getString(R.string.nadar) + SPACE
            if(cineCheckBox.isChecked) pasatiempos = pasatiempos + getString(R.string.cine) + SPACE
            if(comerCheckBox.isChecked) pasatiempos = pasatiempos + " " + getString(R.string.comer)

            val ciudadNacimiento = ciudadNacimientoSpinner.selectedItem

            respuestaTextView.text = resources.getString(R.string.respuesta, nombre, correo, telefono, genero, pasatiempos, ciudadNacimiento)*/
        }
    }

    private fun verificarCamposvacios(nombre: String, correo: String, contrasena: String) {

    }

    private fun registroEnFirebase(correo: String, contrasena: String) {
        auth.createUserWithEmailAndPassword(correo, contrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    goToLoginActivity()
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "error", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}








