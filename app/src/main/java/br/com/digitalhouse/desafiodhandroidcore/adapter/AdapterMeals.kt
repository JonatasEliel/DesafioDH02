package br.com.digitalhouse.desafiodhandroidcore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafiodhandroidcore.R
import br.com.digitalhouse.desafiodhandroidcore.domain.Meals

class AdapterMeals(
    private var mealsList: ArrayList<Meals>,
    val listener: OnClickListenerMeals
) : RecyclerView.Adapter<AdapterMeals.ViewHolderMeals>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterMeals.ViewHolderMeals {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_meal, parent, false)

        return ViewHolderMeals(itemView)
    }

    override fun onBindViewHolder(holder: AdapterMeals.ViewHolderMeals, position: Int) {
        val meal: Meals = mealsList[position]

        holder.cardIvMealPhoto.setImageResource(meal.photo)
        holder.cardIvMealName.text = meal.name
    }

    override fun getItemCount(): Int = mealsList.size

    interface OnClickListenerMeals {
        fun onClickMeals(position: Int)
    }

    inner class ViewHolderMeals(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var cardIvMealPhoto: ImageView = itemView.findViewById(R.id.cardIvMealPhoto)
        var cardIvMealName: TextView = itemView.findViewById(R.id.cardTvMealName)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition

            if (position != RecyclerView.NO_POSITION) {
                listener.onClickMeals(position)
            }
        }
    }
}