package com.example.quotespie.fregment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.quotespie.Quotes_Themes
import com.example.quotespie.R
import com.example.quotespie.binding
import com.example.quotespie.databinding.FragmentProfileBinding

lateinit var bindingProfile: FragmentProfileBinding

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingProfile = FragmentProfileBinding.inflate(inflater, container, false)

        val mode = AppCompatDelegate.getDefaultNightMode()
        bindingProfile.btnThemes.isChecked = (mode == AppCompatDelegate.MODE_NIGHT_YES)

        bindingProfile.btnThemes.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                //Dark Mode
                Quotes_Themes.changeThemes(isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                //Light Mode
                Quotes_Themes.changeThemes(isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        return bindingProfile.root
    }

}