package com.example.attendanceapp.views.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.attendanceapp.PrefManager
import com.example.attendanceapp.databinding.ActivityLoginBinding
import com.example.attendanceapp.networking.RetrofitClient
import com.example.attendanceapp.networking.response.LoginResponse
import com.example.attendanceapp.tools.PREF_ID
import com.example.attendanceapp.tools.PREF_IS_LOGIN

import com.example.attendanceapp.views.main.MainActivity
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private val pref by lazy { PrefManager(this) }
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
    }

    private fun onClick() {
        binding.btnLogin.setOnClickListener {
            login()
        }

    }

    private fun login(){
        RetrofitClient.create(baseContext).postLogin(
            "post_login",
            binding.etPhoneLogin.text.toString(),
            binding.etPasswordLogin.text.toString()
        ).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                if(response?.body()!!.status){
                    pref.setBoolean(PREF_IS_LOGIN,true)
                    pref.setString(PREF_ID,response.body()!!.data.id_karyawan)
                    startActivity<MainActivity>()
                }else{
                    Toast.makeText(baseContext,"Failed",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                Log.d("cek", t.toString())
                Toast.makeText(baseContext,t.toString(),Toast.LENGTH_SHORT).show()
            }
        })
    }
}