package com.pohpoh.hoppark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pohpoh.hoppark.databinding.ActivityMainBinding
import com.pohpoh.hoppark.databinding.ActivitySifrebelirlemeBinding

class sifrebelirleme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivitySifrebelirlemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsifregeri.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnsifreonay.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        supportActionBar?.hide()
    }
}