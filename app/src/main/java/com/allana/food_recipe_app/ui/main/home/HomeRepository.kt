package com.allana.food_recipe_app.ui.main.home

import androidx.lifecycle.MutableLiveData
import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSource
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe

class HomeRepository(private val recipeDataSource: RecipeDataSource) : HomeListContract.Repository {
    override suspend fun getAllRecipe(): List<Recipe> {
        return recipeDataSource.getAllRecipe()
    }

    override suspend fun getAllCategory(): List<Category> {
        return recipeDataSource.getAllCategory()
    }

}