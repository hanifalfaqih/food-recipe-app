package com.allana.food_recipe_app.data.local.room.datasource

import com.allana.food_recipe_app.data.local.room.dao.RecipeDao
import com.allana.food_recipe_app.data.local.room.entity.CategoryRecipe
import com.allana.food_recipe_app.data.local.room.entity.Recipe

class RecipeDataSourceImpl(private val dao: RecipeDao) : RecipeDataSource {
    override suspend fun getAllRecipe(): List<Recipe> {
        return dao.getAllRecipe()
    }

    override suspend fun insertRecipe(recipe: Recipe): Long {
        return dao.insertRecipe(recipe)
    }

    override suspend fun updateRecipe(recipe: Recipe): Int {
        return dao.updateRecipe(recipe)
    }

    override suspend fun deleteRecipe(recipe: Recipe): Int {
        return dao.deleteRecipe(recipe)
    }

    override suspend fun showRecipe(idRecipe: Int): List<Recipe> {
        return dao.showRecipe(idRecipe)
    }


    //    override suspend fun insertRecipe(recipe: List<Recipe>) {
//        return dao.insertRecipe(recipe)
//    }
//
//    override suspend fun insertCategory(category: Category): Long {
//        return dao.insertCategory(category)
//    }
}