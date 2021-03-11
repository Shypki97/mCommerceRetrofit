package com.e.mcommerceretrofit.commercelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.mcommerceretrofit.repository.CommerceRepository
import java.lang.IllegalArgumentException

/**
 *
 * @param repository CommerceRepository
 * @return factory ViewModelProvider.Factory
 */
class ViewModelFactoryCommerceList(private val commerceRepository: CommerceRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CommerceListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CommerceListViewModel(commerceRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}