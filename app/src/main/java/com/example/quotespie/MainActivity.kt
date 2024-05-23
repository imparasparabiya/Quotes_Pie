package com.example.quotespie

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quotespie.Adapter.Quotes_Adapter
import com.example.quotespie.databinding.ActivityMainBinding
import com.example.quotespie.fregment.HomeFragment
import com.example.quotespie.fregment.ProfileFragment
import com.example.quotespie.fregment.SaveFragment
import com.example.quotespie.modal_class.Quotes_ModalClass
import com.google.android.material.navigation.NavigationView

lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val homeFragment = HomeFragment()
        fragmentreples(homeFragment)
        initDrawebalManu()
        binding.bottomAppBar.background = null
        bottomNavigation()
    }

    private fun bottomNavigation() {
        binding.bottomAppBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.btm_Save -> {
                    fragmentreples(SaveFragment())
                    true
                }
                R.id.btm_Home -> {
                    fragmentreples(HomeFragment())
                    true
                }
                R.id.btm_Profile -> {
//                   val intent = Intent(this@MainActivity, ProfileFragment::class.java)
//                    startActivity(intent)
                    fragmentreples(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    @SuppressLint("WrongConstant")
    private fun initDrawebalManu() {
        binding.btnmanu.setOnClickListener {
            binding.main.openDrawer(Gravity.START)
        }
    }

    private fun fragmentreples(fragment: Fragment) {
        val fragmentTranfer = supportFragmentManager.beginTransaction()
        fragmentTranfer.replace(R.id.fragmentFrem, fragment)
        fragmentTranfer.addToBackStack(null)
        fragmentTranfer.commit()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        binding.drawebalManu.setNavigationItemSelectedListener {
           when (p0.itemId){
                R.id.mHome -> {
                    binding.main.closeDrawer(GravityCompat.START)
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mSetting -> {
                    Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mContectus -> {
                    Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.mHelp -> {
                    Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> {
                    false
                }
            }
        }
        return true
   }
}