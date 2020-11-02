package com.daferarevalo.misdeudores.ui.registro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    companion object {
        private const val EMPTY = " "
        private const val SPACE = " "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val datosRecibidos = intent.extras
        val numeroEnviado = datosRecibidos?.getInt("numero")
        Toast.makeText(this, "El numero enviado es $numeroEnviado", Toast.LENGTH_SHORT).show()

        registrar_Button.setOnClickListener {

            val correo = correoEditText.text.toString()
            val contrasena = contrasenaEditText.text.toString()

            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("correo", correo)
            intent.putExtra("contraseña",contrasena)
            startActivity(intent)
            finish()

            val nombre = nombreEditText.text.toString()
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

            respuestaTextView.text = resources.getString(R.string.respuesta, nombre, correo, telefono, genero, pasatiempos, ciudadNacimiento)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}








