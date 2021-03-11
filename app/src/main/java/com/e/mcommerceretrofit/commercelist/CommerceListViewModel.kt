package com.e.mcommerceretrofit.commercelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.mcommerceretrofit.model.Commerce
import com.e.mcommerceretrofit.repository.CommerceRepository

/**
 * @param repository CommerceRepository
 * @return ViewModel
 */
class CommerceListViewModel (commerceRepository: CommerceRepository): ViewModel() {
    /**
     * List initialisé à partir du repository distant.
     */
    val commerceList: LiveData<List<Commerce>> = commerceRepository.getAllCommerce()
}