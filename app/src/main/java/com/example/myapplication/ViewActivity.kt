package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        supportActionBar?.title = "Google Pixel"
    }
}