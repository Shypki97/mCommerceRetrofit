package com.e.mcommerceretrofit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.e.mcommerceretrofit.model.Commerce

/**
 * Base de données permettant de stocker tous les ingrédients
 */
@Database(entities = [Commerce::class], version = 1, exportSchema = false)
abstract class CommerceDatabase: RoomDatabase() {

    abstract fun commerceDao(): CommerceDAO
    companion object{
        @Volatile
        private var INSTANCE: CommerceDatabase? = null

        fun getInstance(context: Context): CommerceDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, CommerceDatabase::class.java,
            "commerce.db").build()

    }
}