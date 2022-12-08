package com.pohpoh.hoppark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pohpoh.hoppark.databinding.ActivityMainActivitysifreyenilemeBinding

class MainActivitysifreyenileme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainActivitysifreyenilemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnileri.setOnClickListener {
            intent= Intent(applicationContext,smsdogrulama::class.java)
            startActivity(intent)
        }
        binding.butongeri.setOnClickListener {
            finish()
        }



        supportActionBar?.hide()
    }
}