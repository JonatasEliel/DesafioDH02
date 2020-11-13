package br.com.digitalhouse.desafiodhandroidcore.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.digitalhouse.desafiodhandroidcore.R
import br.com.digitalhouse.desafiodhandroidcore.adapter.AdapterRestaurant
import br.com.digitalhouse.desafiodhandroidcore.domain.Restaurant
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), AdapterRestaurant.OnClickListenerRestaurant {
    var restaurantList = getAllRestaurants()
    var adapter = AdapterRestaurant(restaurantList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homActRvRestaurants.adapter = adapter
        homActRvRestaurants.layoutManager = LinearLayoutManager(this)
        homActRvRestaurants.setHasFixedSize(true)
    }

    fun getAllRestaurants(): ArrayList<Restaurant> {
        val restaurant1 = Restaurant(
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "Fecha às 22:00",
            R.drawable.camarao
        )
        val restaurant2 = Restaurant(
            "Ayoma - Moema",
            "Alameda dos Arapanés, 532 - Moema",
            "Fecha às 00:00",
            R.drawable.fish
        )
        val restaurant3 = Restaurant(
            "Outback - Moema",
            "Av. Moaci, 187, 187 - Moema, São Paulo",
            "Fecha às 00:00",
            R.drawable.moqueca
        )
        val restaurant4 = Restaurant(
            "Sí Señor!",
            "Alameda Jauaperi, 626 - Moema",
            "Fecha às 01:00",
            R.drawable.breakfast
        )

        return arrayListOf(restaurant1, restaurant2, restaurant3, restaurant4)
    }

    override fun onClickRestaurant(position: Int) {
        val intent = Intent(this, MealsActivity::class.java)
        intent.putExtra("data", restaurantList[position])
        startActivity(intent)
    }
}
