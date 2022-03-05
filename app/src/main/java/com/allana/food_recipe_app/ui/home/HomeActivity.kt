package com.allana.food_recipe_app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.allana.food_recipe_app.databinding.ActivityHomeBinding
import com.allana.food_recipe_app.data.datasource.RecipeDataSource
import com.allana.food_recipe_app.data.model.Recipe
import com.allana.food_recipe_app.ui.home.detail.DetailActivity
import com.allana.food_recipe_app.ui.home.adapter.HomeAdapter
import com.allana.food_recipe_app.ui.home.form.AddRecipeActivity

class HomeActivity : AppCompatActivity(), HomeListContract {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        initView()
        setupSwipeRefresh()
        setupRecycler()
        setupAdapter()
    }

    private fun initView() {
        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, AddRecipeActivity::class.java))
//            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setupSwipeRefresh() {
        binding.srlRecipe.setOnRefreshListener {
            getData()
            binding.srlRecipe.isRefreshing = false
        }
    }

    private fun getData() {

    }

    override fun setupRecycler() {
        binding.rvCategory.layoutManager = GridLayoutManager(applicationContext, 2)
        homeAdapter = HomeAdapter(applicationContext)
        binding.rvCategory.adapter = homeAdapter
        homeAdapter.listener = this
    }

    private fun setupAdapter() {
        val data = RecipeDataSource.createDataSet()
        homeAdapter.submitList(data)
    }

    override fun onItemClicked(view: View, recipe: Recipe) {
        startActivity(Intent(this, DetailActivity::class.java))
    }
}