package com.example.attendanceapp.networking


import com.example.attendanceapp.networking.response.GajiResponse
import com.example.attendanceapp.networking.response.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @FormUrlEncoded
    @POST("rest.php")
    fun postLogin(
        @Query("function") func:String,
        @Field("no_telp") no_tlp:String,
        @Field("password") password:String
    ): Call<LoginResponse>

    @GET("rest.php")
    fun getGaji(
        @Query("function") func:String,
        @Query("id_karyawan") id:String
    ): Call<GajiResponse>
}