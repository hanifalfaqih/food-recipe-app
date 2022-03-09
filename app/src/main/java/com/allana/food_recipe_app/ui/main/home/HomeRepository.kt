package com.allana.food_recipe_app.ui.main.home

import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSource
import com.allana.food_recipe_app.data.local.room.entity.CategoryRecipe
import com.allana.food_recipe_app.data.local.room.entity.Recipe

class HomeRepository(private val recipeDataSource: RecipeDataSource) : HomeListContract.Repository {
    override suspend fun getAllRecipe(): List<Recipe> {
        return recipeDataSource.getAllRecipe()
    }
}