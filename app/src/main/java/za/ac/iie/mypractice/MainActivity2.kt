package za.ac.iie.mypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    // Arrays to store weather data
    private val dates = arrayListOf(
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    )
    private val minTemps = arrayListOf(
        10, 12, 9, 12, 13, 7, 6
    )
    private val maxTemps = arrayListOf(
        18, 22, 17, 18, 25, 16, 14
    )
    private val weatherConditions = arrayListOf(
        "Windy", "Sunny", "Sunny", "Raining", "Sunny", "Cold", "Raining"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initializing UI elements
        val dateEditText = findViewById<EditText>(R.id.dateEditText)
        val minEditText = findViewById<EditText>(R.id.minEditText)
        val maxEditText = findViewById<EditText>(R.id.maxEditText)
        val weatherConditionEditText = findViewById<EditText>(R.id.WeatherConditionEditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val viewDetailsButton = findViewById<Button>(R.id.viewDetailsButton)

        // Add button click listener
        addButton.setOnClickListener {
            val date = dateEditText.text.toString()
            val minTemp = minEditText.text.toString().toIntOrNull()
            val maxTemp = maxEditText.text.toString().toIntOrNull()
            val weather = weatherConditionEditText.text.toString()

            // Check if all fields are filled
            if (date.isNotEmpty() && minTemp != null && maxTemp != null && weather.isNotEmpty()) {
                // Add data to arrays
                dates.add(date)
                minTemps.add(minTemp)
                maxTemps.add(maxTemp)
                weatherConditions.add(weather)
                Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()
                // Clear input fields
                clearFields(dateEditText, minEditText, maxEditText, weatherConditionEditText)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Clear button click listener
        clearButton.setOnClickListener {
            // Uncomment these lines if you want to clear the lists when the clear button is pressed
            // dates.clear()
            // minTemps.clear()
            // maxTemps.clear()
            // weatherConditions.clear()
            // Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()
            // Clear input fields
            clearFields(dateEditText, minEditText, maxEditText, weatherConditionEditText)
        }

        // View details button click listener
        viewDetailsButton.setOnClickListener {
            // Start DetailedViewActivity and pass weather data
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putStringArrayListExtra("dates", dates)
            intent.putIntegerArrayListExtra("minTemps", minTemps)
            intent.putIntegerArrayListExtra("maxTemps", maxTemps)
            intent.putStringArrayListExtra("weatherConditions", weatherConditions)
            startActivity(intent)
        }
    }

    // Function to clear input fields
    private fun clearFields(vararg fields: EditText) {
        for (field in fields) {
            field.text.clear()
        }
    }
}
