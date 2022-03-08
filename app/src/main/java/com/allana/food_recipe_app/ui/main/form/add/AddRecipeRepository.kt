package com.allana.food_recipe_app.ui.main.form.add

import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSource
import com.allana.food_recipe_app.data.local.room.entity.Recipe

class AddRecipeRepository(private val recipeDataSource: RecipeDataSource): AddRecipeContract.Repository {

    override suspend fun insertRecipe(recipe: Recipe): Long {
        return recipeDataSource.insertRecipe(recipe)
    }
}