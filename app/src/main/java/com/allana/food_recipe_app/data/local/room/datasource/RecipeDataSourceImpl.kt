package com.allana.food_recipe_app.data.local.room.datasource

import com.allana.food_recipe_app.data.local.room.dao.RecipeDao
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe

class RecipeDataSourceImpl(private val dao: RecipeDao) : RecipeDataSource {
    override suspend fun getAllRecipe(): List<Recipe> {
        return dao.getAllRecipe()
    }

    override suspend fun getAllCategory(): List<Category> {
        return dao.getAllCategory()
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

}