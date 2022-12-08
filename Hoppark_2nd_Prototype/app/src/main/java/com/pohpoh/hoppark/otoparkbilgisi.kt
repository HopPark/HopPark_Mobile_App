package com.pohpoh.hoppark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pohpoh.hoppark.databinding.ActivityOtoparkbilgisiBinding

class otoparkbilgisi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityOtoparkbilgisiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_otoparkbilgisi)
        binding.btnotoparkgeri.setOnClickListener {
            finish()
        }
        supportActionBar?.hide()
    }
}