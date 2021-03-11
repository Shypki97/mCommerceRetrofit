package com.e.mcommerceretrofit

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.e.mcommerceretrofit.commercelist.ViewModelFactoryCommerceList
import com.e.mcommerceretrofit.db.CommerceDatabase
import com.e.mcommerceretrofit.repository.CommerceRepository
import com.e.mcommerceretrofit.service.CommerceListService
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * sigleton créer le ViewModel avec le service Retrofit, la bdd et un executor.
 * Le résultat est l'absence de dépendances sur ces derniers depuis l'activité.
 */
object Injection {
    private fun provideCommerceRepository (context: Context): CommerceRepository {
        val database = CommerceDatabase.getInstance(context)
        return CommerceRepository(CommerceListService.create(), database.commerceDao(), Executors.newSingleThreadExecutor())
    }

    fun provideViewModelFactoryCommerceList(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryCommerceList(provideCommerceRepository(context))
    }
}