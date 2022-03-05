package com.allana.food_recipe_app.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.data.datasource.RecipeDataSource
import com.allana.food_recipe_app.data.model.Recipe
import com.allana.food_recipe_app.databinding.ActivityDetailBinding
import com.allana.food_recipe_app.ui.home.adapter.HomeAdapter
import com.allana.food_recipe_app.ui.update.EditDeleteActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setClickListeners()
    }

    private fun initView(){
        binding.ivDetailRecipe
        binding.tvTitleDetail
        binding.tvCategoryDetail
        binding.tvIngredientDetail
        binding.tvInstructionDetail
    }

    private fun setupAdapter() {
        val data = RecipeDataSource.createDataSet()
        homeAdapter.submitList(data)
    }

    private fun setClickListeners(){
        binding.btnUpdateDetail.setOnClickListener {
            startActivity(Intent(this,EditDeleteActivity::class.java))
        }
    }
}