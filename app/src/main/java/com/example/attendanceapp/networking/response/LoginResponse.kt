package com.example.attendanceapp.networking.response

import com.example.attendanceapp.model.KaryawanModel

data class LoginResponse(
    val status:Boolean,
    val message:String,
    val data:KaryawanModel
)
