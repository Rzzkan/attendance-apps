package com.example.attendanceapp.networking.response

import com.example.attendanceapp.model.GajiModel
import com.example.attendanceapp.model.KaryawanModel

data class GajiResponse(
    val status:Boolean,
    val message:String,
    val data: ArrayList<GajiModel>
)
