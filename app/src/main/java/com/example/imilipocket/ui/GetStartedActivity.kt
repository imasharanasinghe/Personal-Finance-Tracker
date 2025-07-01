package com.example.imilipocket.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.imilipocket.R

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        val btnGetStarted = findViewById<Button>(R.id.btnletStarted)

        btnGetStarted.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

            // Remove GetStartedActivity from the back stack
            finish() // This will close the GetStartedActivity and prevent going back to it
        }
    }
}
