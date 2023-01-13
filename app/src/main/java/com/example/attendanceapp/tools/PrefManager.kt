package com.example.attendanceapp

import android.content.Context
import android.content.SharedPreferences
private const val PREF_NAME = "app.pref"

class PrefManager (context: Context){
    private var sharedPref: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor

    init {
        editor = sharedPref.edit()
    }

    fun setBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }

    fun setString(key: String, value: String){
        editor.putString(key,value)
            .apply()
    }

    fun getString(key:String): String? {
        return sharedPref.getString(key,"")
    }

    fun removeSP(){
        editor.clear()
            .apply()
    }
}