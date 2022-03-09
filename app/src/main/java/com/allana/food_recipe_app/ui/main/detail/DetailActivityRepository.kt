package com.allana.food_recipe_app.ui.main.detail

import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSource
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import com.allana.food_recipe_app.ui.main.detail.DetailActivityContract

class DetailActivityRepository(
    private val localDataSource: RecipeDataSource
) : DetailActivityContract.Repository {
    override suspend fun showRecipe(idRecipe: Int): List<Recipe> {
        return localDataSource.showRecipe(idRecipe)
    }

    override suspend fun getAllCategory(): List<Category> {
        return localDataSource.getAllCategory()
    }

}