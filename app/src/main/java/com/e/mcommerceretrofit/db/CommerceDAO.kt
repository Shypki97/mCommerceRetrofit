package com.e.mcommerceretrofit.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.e.mcommerceretrofit.model.Commerce

/**
 *
 */
@Dao
interface CommerceDAO{
    /**
     * Ajouter une liste d'ingredients
     * OnConflictStrategy.REPLACE permet de ne pas avoir de doublon et met à jour nos données
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(commerceList: List<Commerce>)

    /**
     * Obtenir tous les ingrédients
     */
    @Query("SELECT id, name, price, image FROM commerce")
    fun getAllCommerce(): LiveData<List<Commerce>>
}