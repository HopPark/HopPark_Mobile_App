package com.pohpoh.hoppark
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pohpoh.hoppark.databinding.ActivityMainBinding
import com.pohpoh.hoppark.databinding.ActivitySmsdogrulamaBinding

class smsdogrulama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivitySmsdogrulamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnonay.setOnClickListener {
            intent= Intent(applicationContext,sifrebelirleme::class.java)
            startActivity(intent)
        }
        binding.btngeri2.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        supportActionBar?.hide()
    }
}