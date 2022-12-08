package com.pohpoh.hoppark



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pohpoh.hoppark.databinding.ActivityMainBinding
import com.pohpoh.hoppark.databinding.ActivityMainkayitolBinding

class Mainkayitol : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainkayitolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnkayitol.setOnClickListener {
            var kullaniciEmail = binding.textEmail.text.toString()
            var kullaniciParola = binding.textSifre.text.toString()
            var kullaniciAd = binding.textAd.text.toString()
            var kullaniciSoyad = binding.textSoyad.text.toString()
            var kullaniciKimlikNo = binding.textKimlikNo.text.toString()
            var kullaniciGsmNo = binding.textGsmNo.text.toString()

            var SharedPreferences = this.getSharedPreferences("Bilgiler", MODE_PRIVATE)
            var editor = SharedPreferences.edit()

            editor.putString("Kullanıcı Email","$kullaniciEmail").apply()
            editor.putString("Kullanıcı Parola","$kullaniciParola").apply()
            editor.putString("Kullanıcı Ad","$kullaniciAd").apply()
            editor.putString("Kullanıcı Soyad","$kullaniciSoyad").apply()
            editor.putString("Kullanıcı Kimlik No","$kullaniciKimlikNo").apply()
            editor.putString("Kullanıcı Gsm No","$kullaniciGsmNo").apply()

            if(kullaniciEmail!="" && kullaniciAd!="" && kullaniciSoyad!="" && kullaniciParola!="" &&
                kullaniciGsmNo!="" && kullaniciKimlikNo!=""){
                Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_LONG).show()


                intent= Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext,"Bilgileri eksiksiz giriniz",Toast.LENGTH_LONG).show()
            }
        }

        binding.btnGeri.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        supportActionBar?.hide()
    }
}