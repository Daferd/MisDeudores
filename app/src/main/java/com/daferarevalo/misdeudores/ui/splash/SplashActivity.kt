package com.daferarevalo.misdeudores.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daferarevalo.misdeudores.R
import com.daferarevalo.misdeudores.ui.bottom.BottomActivity
import com.daferarevalo.misdeudores.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = FirebaseAuth.getInstance()
        val timer = Timer()
        timer.schedule(
            timerTask {
                val auth = FirebaseAuth.getInstance()
                if (auth.uid == null) {
                    goToLoginActivity()
                } else {
                    goToBottomActivity()
                }
            }, 2000
        )
    }

    fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goToBottomActivity() {
        val intent = Intent(this, BottomActivity::class.java)
        startActivity(intent)
        finish()
    }
}