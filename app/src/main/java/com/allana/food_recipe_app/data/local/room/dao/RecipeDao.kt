package com.allana.food_recipe_app.data.local.room.dao

import androidx.room.*
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe

@Dao
interface RecipeDao {

    /**
     * Use to get list of data recipes
     */
    @Query("SELECT * FROM recipes")
    suspend fun getAllRecipe(): List<Recipe>

    @Query("SELECT * FROM categories")
    suspend fun getAllCategory(): List<Category>

    @Insert
    suspend fun insertRecipe(recipe: Recipe): Long

    @Update
    suspend fun updateRecipe(recipe: Recipe): Int

    @Delete
    suspend fun deleteRecipe(recipe: Recipe): Int

    @Query("SELECT * FROM RECIPES WHERE IDRECIPE == :idRecipe")
    suspend fun showRecipe(idRecipe : Int): List<Recipe>

    /**
     * Use to prepopulate data category
     * Insert all data category with list
     */
    @Insert
    fun insertAllCategory(category: List<Category>)

}