package com.allana.food_recipe_app.data.local.room.datasource

import com.allana.food_recipe_app.data.local.room.dao.RecipeDao
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.CategoryRecipe
import com.allana.food_recipe_app.data.local.room.entity.Recipe

class RecipeDataSourceImpl(private val dao: RecipeDao) : RecipeDataSource {
    override suspend fun getAllCategoryRecipe(): List<CategoryRecipe> {
        return dao.getAllCategoryRecipe()
    }

    override suspend fun insertRecipe(recipe: List<Recipe>) {
        return dao.insertRecipe(recipe)
    }

    override suspend fun insertCategory(category: Category): Long {
        return dao.insertCategory(category)
    }

    override suspend fun updateRecipe(recipe: Recipe): Int {
        return dao.updateRecipe(recipe)
    }
}