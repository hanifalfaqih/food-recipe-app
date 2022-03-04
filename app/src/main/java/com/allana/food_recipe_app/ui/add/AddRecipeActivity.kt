package com.allana.food_recipe_app.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.databinding.ActivityAddRecipeBinding

class AddRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.text_action_bar_add_activity)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}