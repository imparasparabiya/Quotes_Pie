package com.example.quotespie

import android.annotation.SuppressLint
import android.app.Application
import android.app.SharedElementCallback
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDialog
import com.example.quotespie.Quotes_Themes.Companion.sp

class Quotes_Themes : Application() {
    companion object {
        var sp: SharedPreferences? = null

        fun changeThemes(isThemes: Boolean) {
            var editor = sp?.edit()
            editor?.putBoolean("themes", isThemes)
            editor?.apply()
        }
    }

    override fun onCreate() {
        super.onCreate()
        initShared()
        getThemesData()
    }

    private fun initShared() {
            sp =getSharedPreferences("themes", MODE_PRIVATE)
    }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getThemesData() {
    val isThemes = sp?.getBoolean("themes", false)
        if (isThemes == true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

