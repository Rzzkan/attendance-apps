package com.example.attendanceapp.views.salary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.attendanceapp.PrefManager
import com.example.attendanceapp.R
import com.example.attendanceapp.model.GajiModel
import com.example.attendanceapp.networking.RetrofitClient
import com.example.attendanceapp.networking.response.GajiResponse
import com.example.attendanceapp.tools.PREF_ID
import com.example.attendanceapp.views.adapter.GajiAdapter
import kotlinx.android.synthetic.main.activity_salary.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SalaryActivity : AppCompatActivity() {
    private val pref by lazy { PrefManager(this) }
    private val list = ArrayList<GajiModel>()
    lateinit var adapter: GajiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salary)
        initialization()
        getGaji()
    }
    fun initialization(){
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)
        adapter = GajiAdapter()
        rvPost.adapter = adapter
    }
    fun getGaji(){
        RetrofitClient.create(baseContext).getGaji(
            "get_gaji",
            pref.getString(PREF_ID).toString()
        ).enqueue(object : Callback<GajiResponse> {
            override fun onResponse(call: Call<GajiResponse>?, response: Response<GajiResponse>?) {
                if(response?.body()!!.status){
                    list.addAll(response.body()!!.data)
                    adapter.setArrayList(list)
                }
            }
            override fun onFailure(call: Call<GajiResponse>?, t: Throwable?) {

                Log.d("cek", t.toString())
            }
        })
    }
}
