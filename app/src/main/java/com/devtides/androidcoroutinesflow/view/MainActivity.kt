package com.devtides.androidcoroutinesflow.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.devtides.androidcoroutinesflow.databinding.ActivityMainBinding
import com.devtides.androidcoroutinesflow.viewmodel.ListViewModel
import com.devtides.coroutinesretrofit.view.NewsListAdapter

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val newsListAdapter = NewsListAdapter()

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        binding.newsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.newsArticles.observe(this, Observer { article ->

        })
    }
}
