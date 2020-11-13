package br.com.digitalhouse.desafiodhandroidcore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafiodhandroidcore.R
import br.com.digitalhouse.desafiodhandroidcore.domain.Meals
import kotlinx.android.synthetic.main.activity_meal.*

class MealActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)

        setUpOnClickListeners()

        var meal = intent.getSerializableExtra("data") as? Meals

        if (meal != null) {
            mealActIvPhoto.setImageResource(meal.photo)
            mealActTvName.text = meal.name
        }
    }

    fun setUpOnClickListeners() {
        mealActIbBack.setOnClickListener {
            finish()
        }
    }
}