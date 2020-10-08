package com.daferarevalo.misdeudores.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.ui.registro.RegistroActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registrar_button.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            intent.putExtra("numero", 1)
            startActivity(intent)
            finish()
        }
    }


}