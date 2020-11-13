package br.com.digitalhouse.desafiodhandroidcore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafiodhandroidcore.R
import br.com.digitalhouse.desafiodhandroidcore.domain.Restaurant
import kotlin.collections.ArrayList

class AdapterRestaurant(
    private val restaurantList: ArrayList<Restaurant>,
    val listener: OnClickListenerRestaurant
) : RecyclerView.Adapter<AdapterRestaurant.ViewHolderRestaurant>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderRestaurant {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_restaurant, parent, false)

        return ViewHolderRestaurant(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderRestaurant, position: Int) {
        val restaurant: Restaurant = restaurantList[position]

        holder.cardIvPhoto.setImageResource(restaurant.photo)
        holder.cardTvName.text = restaurant.name
        holder.cardIvAddress.text = restaurant.address
        holder.cardIvClosingHours.text = restaurant.closingHours
    }

    override fun getItemCount(): Int = restaurantList.size

    interface OnClickListenerRestaurant {
        fun onClickRestaurant(position: Int)
    }

    inner class ViewHolderRestaurant(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var cardIvPhoto: ImageView = itemView.findViewById(R.id.cardIvPhoto)
        var cardTvName: TextView = itemView.findViewById(R.id.cardTvName)
        var cardIvAddress: TextView = itemView.findViewById(R.id.cardTvAddress)
        var cardIvClosingHours: TextView = itemView.findViewById(R.id.cardTvClosingHours)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition

            if (position != RecyclerView.NO_POSITION) {
                listener.onClickRestaurant(position)
            }
        }
    }
}