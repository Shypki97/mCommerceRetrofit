package com.e.mcommerceretrofit.commercelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.e.mcommerceretrofit.Injection
import com.e.mcommerceretrofit.R
import com.e.mcommerceretrofit.model.Commerce
import kotlinx.android.synthetic.main.activity_main.*

class CommerceListActivity : AppCompatActivity(){

    private lateinit var viewModelCommerceList: CommerceListViewModel
    private var adapter = CommerceAdapter()

    /**
     * Le ViewModel initialisé grâce au factory et objet injection
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelCommerceList = ViewModelProvider(this, Injection.provideViewModelFactoryCommerceList(this))
            .get(CommerceListViewModel::class.java)
        initAdapter()
    }

    private fun initAdapter(){
        list.layoutManager = LinearLayoutManager(applicationContext)
        list.adapter = adapter


        viewModelCommerceList.commerceList.observe(this, Observer<List<Commerce>>{
            adapter.submitList(it)
        })
    }
}