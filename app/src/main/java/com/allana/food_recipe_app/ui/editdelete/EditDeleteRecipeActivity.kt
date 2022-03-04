package com.allana.food_recipe_app.ui.editdelete

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.databinding.ActivityEditDeleteRecipeBinding

class EditDeleteRecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditDeleteRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditDeleteRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }
    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.text_action_bar_edit_delete_activity)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}