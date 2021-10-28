package com.apolis.animsearch.ui.animesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.apolis.animsearch.R
import com.apolis.animsearch.api.ApiClient
import com.apolis.animsearch.api.Repository
import com.apolis.animsearch.databinding.ActivityMainBinding
import com.apolis.animsearch.ui.adapter.AnimeAdapter

class MainActivity : AppCompatActivity() {
    lateinit var adapter: AnimeAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        binding.rvAnime.layoutManager = LinearLayoutManager(this)
        initViewModel()
        setupObservers()
    }

    fun initViewModel() {
        val factory = MainViewModelFactory(Repository(ApiClient.apiService))
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        binding.viewModel = viewModel
    }

    fun setupObservers() {
        viewModel.error.observe(this) {
            Toast.makeText(baseContext, it, Toast.LENGTH_LONG).show()
        }

        viewModel.searchResults.observe(this) {
            adapter = AnimeAdapter(it)
            binding.rvAnime.adapter = adapter
        }

    }
}