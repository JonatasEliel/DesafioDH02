package br.com.digitalhouse.desafiodhandroidcore.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.digitalhouse.desafiodhandroidcore.R
import br.com.digitalhouse.desafiodhandroidcore.adapter.AdapterMeals
import br.com.digitalhouse.desafiodhandroidcore.adapter.AdapterRestaurant
import br.com.digitalhouse.desafiodhandroidcore.domain.Meals
import br.com.digitalhouse.desafiodhandroidcore.domain.Restaurant
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_meals.*

class MealsActivity : AppCompatActivity(), AdapterMeals.OnClickListenerMeals {
    var mealsList = getAllMeals()
    var adapter = AdapterMeals(mealsList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals)

        setUpOnClickListeners()

        var restaurant = intent.getSerializableExtra("data") as? Restaurant

        if (restaurant != null) {
            meaActIvPhoto.setImageResource(restaurant.photo)
            meaActTvName.text = restaurant.name
        }

        meaActRvMeals.adapter = adapter
        meaActRvMeals.layoutManager = GridLayoutManager(this, 2)
        meaActRvMeals.setHasFixedSize(true)
    }

    fun getAllMeals(): ArrayList<Meals> {
        val meal1 = Meals("Salada com molho de Gengibre", R.drawable.breakfast)
        val meal2 = Meals("Salada com molho de Gengibre", R.drawable.camarao)
        val meal3 = Meals("Salada com molho de Gengibre", R.drawable.fish)
        val meal4 = Meals("Salada com molho de Gengibre", R.drawable.moqueca)
        val meal5 = Meals("Salada com molho de Gengibre", R.drawable.splash_screen)
        val meal6 = Meals("Salada com molho de Gengibre", R.drawable.breakfast)
        val meal7 = Meals("Salada com molho de Gengibre", R.drawable.camarao)
        val meal8 = Meals("Salada com molho de Gengibre", R.drawable.fish)
        val meal9 = Meals("Salada com molho de Gengibre", R.drawable.moqueca)
        val meal10 = Meals("Salada com molho de Gengibre", R.drawable.splash_screen)
        val meal11 = Meals("Salada com molho de Gengibre", R.drawable.breakfast)

        return arrayListOf(meal1, meal2, meal3, meal4, meal5, meal6, meal7, meal8, meal9, meal10, meal11)
    }

    override fun onClickMeals(position: Int) {
        val intent = Intent(this, MealActivity::class.java)
        intent.putExtra("data", mealsList[position])
        startActivity(intent)
    }

    fun setUpOnClickListeners() {
        meaActIbBack.setOnClickListener {
            finish()
        }
    }
}