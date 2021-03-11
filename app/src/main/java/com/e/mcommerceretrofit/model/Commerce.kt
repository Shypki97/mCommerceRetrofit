package com.e.mcommerceretrofit.model

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @Entity permet de crée la table dans la base de données
 * La bibliothèque Room permet un accès simplifié et robustre à une base de données SQLite
 */

@Entity(tableName = "commerce")
data class Commerce(@PrimaryKey @field:SerializedName("id") val id: Int,
                    @field:SerializedName("name") val name:String = "",
                    @field:SerializedName("price") val price:Double = 0.0,
                    @field:SerializedName("image") val image:String = "" )
