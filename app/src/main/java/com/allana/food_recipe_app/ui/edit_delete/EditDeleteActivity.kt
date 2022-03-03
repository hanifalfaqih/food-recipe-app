package com.allana.food_recipe_app.ui.edit_delete

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.allana.food_recipe_app.databinding.ActivityEditDeleteBinding

class EditDeleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditDeleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }
    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) this.finish()
        return super.onOptionsItemSelected(item)
    }
}