package com.allana.food_recipe_app.data.local.room.datasource

import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe

interface RecipeDataSource {
    suspend fun getAllRecipe(): List<Recipe>

    suspend fun getAllCategory(): List<Category>

    suspend fun insertRecipe(recipe: Recipe): Long

    suspend fun updateRecipe(recipe: Recipe): Int

    suspend fun deleteRecipe(recipe: Recipe): Int
}