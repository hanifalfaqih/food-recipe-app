package com.allana.food_recipe_app.ui.home.detail

import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSource
import com.allana.food_recipe_app.data.local.room.entity.Recipe

class DetailActivityRepository(
    private val localDataSource: RecipeDataSource
) : DetailActivityContract.Repository {
    override suspend fun showRecipe(idRecipe: Int): List<Recipe> {
        return localDataSource.showRecipe(idRecipe)
    }

}