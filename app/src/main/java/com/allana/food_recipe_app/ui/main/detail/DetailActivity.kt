package com.allana.food_recipe_app.ui.main.detail

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.databinding.ActivityDetailBinding
import com.allana.food_recipe_app.ui.main.form.editdelete.EditDeleteRecipeActivity

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
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF672C")))

        binding.ivDetailRecipe
        binding.tvTitleDetail
        binding.tvCategoryDetail
        binding.tvIngredientDetail
        binding.tvInstructionDetail
    }


    private fun setClickListeners(){
        binding.btnUpdateDetail.setOnClickListener {
            startActivity(Intent(this, EditDeleteRecipeActivity::class.java))
        }
    }
}