package com.pohpoh.hoppark



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.pohpoh.hoppark.databinding.ActivityProfilBinding

class Profil : AppCompatActivity() {
    lateinit var binding: ActivityProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        supportActionBar?.hide()
        var sharedPreferences = this.getSharedPreferences("Bilgiler", MODE_PRIVATE)
        var ad=sharedPreferences.getString("Kullanıcı Ad","")
        var soyad=sharedPreferences.getString("Kullanıcı Soyad","")
        var email=sharedPreferences.getString("Kullanıcı Email","")
        var kimlikNo=sharedPreferences.getString("Kullanıcı Kimlik No","")
        var gsmNo=sharedPreferences.getString("Kullanıcı Gsm No","")


        binding = ActivityProfilBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.adSoyadText.setText("Ad Soyad : "+ad+" "+soyad)
        binding.kimlikNoText.setText("Kimlik No : "+kimlikNo)
        binding.emailText.setText("E-mail : "+email)
        binding.gsmText.setText("Telefon No : "+gsmNo)



    }
}