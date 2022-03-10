package com.allana.food_recipe_app.ui.main.detail

import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSource

class DetailActivityRepository(
    private val localDataSource: RecipeDataSource
) : DetailActivityContract.Repository