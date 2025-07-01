package com.example.imilipocket.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.imilipocket.R
import com.example.imilipocket.ui.GetStartedActivity
import com.example.imilipocket.ui.MainActivity

class OnboardingThreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_three)

        val btnGetStarted = findViewById<Button>(R.id.btnGetStarted)
        btnGetStarted.setOnClickListener {
            startActivity(Intent(this, GetStartedActivity::class.java))
            finish()
        }
    }
}
