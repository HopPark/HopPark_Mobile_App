package com.pohpoh.hoppark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pohpoh.hoppark.databinding.ActivityAyarlarBinding
import com.pohpoh.hoppark.databinding.ActivityMainkayitolBinding

class Ayarlar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityAyarlarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btncikisyap.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }

        binding.textSifreDegistir.setOnClickListener{
            intent= Intent(applicationContext,MainActivitysifreyenileme::class.java)
            startActivity(intent)
        }
        supportActionBar?.hide()
    }
}