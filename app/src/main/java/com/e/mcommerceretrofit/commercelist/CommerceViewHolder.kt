package com.e.mcommerceretrofit.commercelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.mcommerceretrofit.R
import com.e.mcommerceretrofit.model.Commerce

/**
 * Cette classe permet d'initialiser les TextView et ImageView de l'activité
 */
class CommerceViewHolder (view: View): RecyclerView.ViewHolder(view){
    private val commerceName: TextView = view.findViewById(R.id.name)
    private val commercePrice : TextView = view.findViewById(R.id.price)
    private var commerceImage: ImageView = view.findViewById(R.id.image)

    fun bind(commerce: Commerce?){
        if(commerce != null){
            showCommerceData(commerce)
        }
    }

    fun showCommerceData(commerce: Commerce){
        commerce.apply {
            commerceName.text = name
            commercePrice.text = price.toString() + " €"
        }

    }

    companion object{
        fun create(parent: ViewGroup): CommerceViewHolder{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.listview, parent, false)
            return CommerceViewHolder(view)
        }
    }
}

