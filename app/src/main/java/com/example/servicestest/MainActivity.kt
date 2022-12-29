package com.example.servicestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.servicestest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonService.setOnClickListener {
            startService(MyService.newIntent(this, 50))
        }
    }
}