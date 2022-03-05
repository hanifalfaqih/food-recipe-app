package com.allana.food_recipe_app.data.local.room.datasource

import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.CategoryRecipe
import com.allana.food_recipe_app.data.local.room.entity.Recipe

interface RecipeDataSource {
    suspend fun getAllCategoryRecipe(): List<CategoryRecipe>

    suspend fun insertRecipe(recipe: List<Recipe>)

    suspend fun insertCategory(category: Category): Long
}