package za.ac.iie.mypractice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        // Initialize UI elements
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        val backButton = findViewById<Button>(R.id.backButton)

        // Retrieve data passed from MainActivity2
        val dates = intent.getStringArrayListExtra("dates")
        val minTemps = intent.getIntegerArrayListExtra("minTemps")
        val maxTemps = intent.getIntegerArrayListExtra("maxTemps")
        val weatherConditions = intent.getStringArrayListExtra("weatherConditions")

        // Build the details string
        val details = StringBuilder()
        // Check if all arrays are not null and have the same size
        if (dates != null && minTemps != null && maxTemps != null && weatherConditions != null &&
            dates.size == minTemps.size && minTemps.size == maxTemps.size && maxTemps.size == weatherConditions.size) {
            // Loop through the arrays to display details
            for (i in dates.indices) {
                details.append("Date: ${dates[i]}\n")
                details.append("Min Temp: ${minTemps[i]}\n")
                details.append("Max Temp: ${maxTemps[i]}\n")
                details.append("Weather: ${weatherConditions[i]}\n")
                details.append("\n")
            }
        }

        // Set the details text
        detailsTextView.text = details.toString()

        // Back button click listener
        backButton.setOnClickListener {
            finish() // Finish this activity and go back to the previous one
        }
    }
}
