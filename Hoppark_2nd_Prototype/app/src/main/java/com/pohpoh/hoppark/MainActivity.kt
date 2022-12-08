package com.pohpoh.hoppark


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pohpoh.hoppark.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        preferences=getSharedPreferences("Bilgiler", MODE_PRIVATE)

        binding.btngirisyap.setOnClickListener {

            var kayitliEmail= preferences.getString("Kullanıcı Email","")
            var kayitliParola= preferences.getString("Kullanıcı Parola","")

            var girisEmail=binding.editTextTextPersonName.text.toString()
            var girisParola=binding.editTextTextPassword.text.toString()

            if(girisEmail!="" && girisParola!="")
            {
                if((kayitliEmail==girisEmail)&&(kayitliParola==girisParola))
                {
                    Toast.makeText(applicationContext,"Giriş Başarılı",Toast.LENGTH_LONG).show()
                    intent= Intent(applicationContext,map::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(applicationContext,"Kullanıcı Bilgileri Hatalı",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext, "Kullanıcı Bilgileri Eksik", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnkayitol.setOnClickListener {
            intent= Intent(applicationContext,Mainkayitol::class.java)
            startActivity(intent)
        }
        binding.sifremiunuttum.setOnClickListener{
            intent= Intent(applicationContext,MainActivitysifreyenileme::class.java)
            startActivity(intent)
        }
        supportActionBar?.hide()
    }
}