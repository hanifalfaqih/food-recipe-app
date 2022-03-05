package com.allana.food_recipe_app.ui.home

import android.view.View
import com.allana.food_recipe_app.data.model.Recipe

interface RecyclerViewClickListener {
    fun onItemClicked(view: View, recipe: Recipe)
}