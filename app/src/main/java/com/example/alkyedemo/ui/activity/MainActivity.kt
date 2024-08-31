package com.example.alkyedemo.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.alkyedemo.R
import com.example.alkyedemo.databinding.ActivityMainBinding
import com.example.alkyedemo.utils.launchActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.clickHandler = this
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.signInButton -> {
                launchActivity<HomeActivity>()
            }
            R.id.signUpButton -> {
                launchActivity<HomeActivity>()
            }
        }
    }
}