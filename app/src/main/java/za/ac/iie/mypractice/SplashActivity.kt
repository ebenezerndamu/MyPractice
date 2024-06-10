package za.ac.iie.mypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize startButton and exitButton from layout
        val startButton = findViewById<Button>(R.id.startButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        // Set click listener for startButton
        startButton.setOnClickListener {
            // When startButton is clicked, create an Intent to start MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent) // Start MainActivity2
        }

        // Set click listener for exitButton
        exitButton.setOnClickListener {
            finish() // Close the SplashActivity
        }
    }
}
