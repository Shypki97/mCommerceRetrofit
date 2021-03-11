package com.e.mcommerceretrofit.repository

import androidx.lifecycle.LiveData
import com.e.mcommerceretrofit.db.CommerceDAO
import com.e.mcommerceretrofit.model.Commerce
import com.e.mcommerceretrofit.service.CommerceListService
import com.e.mcommerceretrofit.service.requestCommerce
import java.util.concurrent.Executor

/**
 * Classe qui détient la donnée.
 * @param service Rétrofit CommerceListService
 * @param DAO CommerceDAO
 * @param Executor
 */
class CommerceRepository(private val commerceListService: CommerceListService,
                        private val commerceDAO: CommerceDAO,
                        private val ioExecutor: Executor){

    /**
     * Ici "requestCommerce" permet de télécharger la donnée via Retrofit. Aprés récuperation
     * des données, l'insertion de ces dernières s'execute sur un thread différent de l'UI.
     * @return objet LiveData contenant la liste des ingrédients depuis la DAO
     */
    fun getAllCommerce(): LiveData<List<Commerce>>{
        requestCommerce(commerceListService, {
            commerce -> ioExecutor.execute{
            commerceDAO.insertAll(commerce)}
        }, {error ->


        })
        return commerceDAO.getAllCommerce()
    }
}