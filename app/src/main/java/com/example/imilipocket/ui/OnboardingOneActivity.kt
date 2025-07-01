package com.example.imilipocket.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.imilipocket.R

class OnboardingOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            startActivity(Intent(this, OnboardingTwoActivity::class.java))
            finish()
        }
    }
}
