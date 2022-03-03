package com.allana.food_recipe_app.ui.update

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aemerse.slider.model.CarouselItem
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.databinding.ActivityEditDeleteBinding

class EditDeleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditDeleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initImageViewCarousel()
    }
    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
    }

    private fun initImageViewCarousel() {
        val carousel = binding.ivEditDelete
        carousel.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()
        list.add(CarouselItem(imageDrawable = R.drawable.dummy_iv_edit_delete))
        list.add(CarouselItem(imageDrawable = R.drawable.dummy_iv_edit_delete))
        list.add(CarouselItem(imageDrawable = R.drawable.dummy_iv_edit_delete))

        carousel.setData(list)
    }
}