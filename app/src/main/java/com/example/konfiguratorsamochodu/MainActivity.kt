package com.example.konfiguratorsamochodu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val checkBoxKlimatyzacja = findViewById<CheckBox>(R.id.checkBoxKlimatyzacja)
        val checkBoxSkorzaneSiedzenia = findViewById<CheckBox>(R.id.checkBoxSkorzaneSiedzenia)
        val buttonZatwierdz = findViewById<Button>(R.id.buttonZatwierdz)
        val textViewPodsumowanie = findViewById<TextView>(R.id.textViewPodsumowanie)
        val imageViewCar = findViewById<ImageView>(R.id.imageViewCar)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioSedan -> imageViewCar.setImageResource(R.drawable.sedan)
                R.id.radioSUV -> imageViewCar.setImageResource(R.drawable.suv)
                R.id.radioHatchback -> imageViewCar.setImageResource(R.drawable.hatchback)
            }
        }

        buttonZatwierdz.setOnClickListener {
            val wybor = when (radioGroup.checkedRadioButtonId) {
                R.id.radioSedan -> "Sedan"
                R.id.radioSUV -> "SUV"
                R.id.radioHatchback -> "Hatchback"
                else -> "Nie wybrano modelu samochodu"
            }

            val klimatyzacja = if (checkBoxKlimatyzacja.isChecked) "Klimatyzacja" else ""
            val skorzaneSiedzenia = if (checkBoxSkorzaneSiedzenia.isChecked) "Skórzane siedzenia" else ""

            val podsumowanie = "Wybrany model: $wybor $klimatyzacja $skorzaneSiedzenia"
            textViewPodsumowanie.text = podsumowanie
        }
    }
}