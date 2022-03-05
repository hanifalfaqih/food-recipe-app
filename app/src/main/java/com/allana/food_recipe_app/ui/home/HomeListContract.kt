package com.allana.food_recipe_app.ui.home

import android.view.View
import com.allana.food_recipe_app.data.model.Recipe

interface HomeListContract {
    fun onItemClicked(view: View, recipe: Recipe)
    fun setupSwipeRefresh()
    fun setupRecycler()
}