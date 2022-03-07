package com.allana.food_recipe_app.data.local.room.dao

import androidx.room.*
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.CategoryRecipe
import com.allana.food_recipe_app.data.local.room.entity.Recipe

@Dao
interface RecipeDao {
    @Transaction
    suspend fun addCategoryRecipe(category: Category, items: List<Recipe>) {
        val listId = insertCategory(category)

        items.forEach { it.idCategoryRecipe = listId.toInt() }
        insertRecipe(items)
    }

    @Query("SELECT * FROM CATEGORIES")
    suspend fun getAllCategoryRecipe(): List<CategoryRecipe>

    @Insert
    suspend fun insertRecipe(recipe: List<Recipe>)

    @Insert
    suspend fun insertCategory(category: Category): Long

    @Update
    suspend fun updateRecipe(recipe: Recipe): Int
}