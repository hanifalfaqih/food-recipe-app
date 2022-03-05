package com.allana.food_recipe_app.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.databinding.ActivityDetailBinding
import com.allana.food_recipe_app.ui.editdelete.EditDeleteRecipeActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setClickListeners()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun initView(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.text_detail_recipe)

        binding.ivDetailRecipe
        binding.tvTitleDetail
        binding.tvCategoryDetail
        binding.tvIngredientDetail
        binding.tvInstructionDetail
    }


    private fun setClickListeners(){
        binding.btnUpdateDetail.setOnClickListener {
            startActivity(Intent(this,EditDeleteRecipeActivity::class.java))
        }
    }
}