package com.pohpoh.hoppark



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class parklist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parklist)
        supportActionBar?.hide()
    }

}