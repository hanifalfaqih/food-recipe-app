package com.allana.food_recipe_app.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.databinding.ActivityHomeBinding
import com.allana.food_recipe_app.ui.data.datasource.RecipeDataSource
import com.allana.food_recipe_app.ui.data.model.Recipe
import com.allana.food_recipe_app.ui.home.adapter.HomeAdapter
import com.bumptech.glide.Glide

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private var recipeList = mutableListOf<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        initView()
        setupRecycler()
        setupAdapter()
    }

    private fun initView() {
        binding.fabAdd.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecycler() {
        binding.rvCategory.layoutManager = GridLayoutManager(applicationContext, 2)
        homeAdapter = HomeAdapter(applicationContext)
        binding.rvCategory.adapter = homeAdapter
    }

    private fun setupAdapter() {
        val data = RecipeDataSource.createDataSet()
        homeAdapter.submitList(data)
    }
}