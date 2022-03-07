package com.allana.food_recipe_app.data.local.room.dao

import androidx.room.*
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.CategoryRecipe
import com.allana.food_recipe_app.data.local.room.entity.Recipe

@Dao
interface RecipeDao {


    //    @Transaction
//    suspend fun addCategoryRecipe(category: Category, items: List<Recipe>) {
//        val listId = insertCategory(category)
//
//        items.forEach { it.idCategoryRecipe = listId.toInt() }
//        insertRecipe(items)
//    }

    //    @Insert
//    suspend fun insertRecipe(recipe: List<Recipe>)
//
//    @Insert
//    suspend fun insertCategory(category: Category): Long


    @Insert
    suspend fun insertRecipe(recipe: Recipe): Long

    @Update
    suspend fun updateRecipe(recipe: Recipe): Int

    @Delete
    suspend fun deleteRecipe(recipe: Recipe): Int

    /**
     * Use to prepopulate data category
     * Insert all data category with list
     */
    @Insert
    fun insertAllCategory(category: List<Category>)

//    /**
//     * Use to get list of data recipes
//     */
//    @Query("SELECT * FROM recipes")
//    fun getAllRecipe(): List<Recipe>
//
//    /**
//     * Use to get list of categories with their recipes
//     */
//    @Transaction
//    @Query("SELECT * FROM categories")
//    fun getCategoriesAndRecipe(): List<CategoryRecipe>

}