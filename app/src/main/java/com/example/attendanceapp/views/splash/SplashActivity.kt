package com.example.attendanceapp.views.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.attendanceapp.PrefManager
import com.example.attendanceapp.R
import com.example.attendanceapp.tools.PREF_IS_LOGIN
import com.example.attendanceapp.views.login.LoginActivity
import com.example.attendanceapp.views.main.MainActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {
    private val pref by lazy { PrefManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        afterDelayGoToLogin()
    }

    private fun afterDelayGoToLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (!pref.getBoolean(PREF_IS_LOGIN))
                startActivity<LoginActivity>()
            else
                startActivity<MainActivity>()
            finishAffinity()
        },1200)
    }
}