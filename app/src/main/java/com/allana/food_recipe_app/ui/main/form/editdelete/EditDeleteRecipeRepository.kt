package com.allana.food_recipe_app.ui.main.form.editdelete

import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSource
import com.allana.food_recipe_app.data.local.room.entity.Recipe

class EditDeleteRecipeRepository(private val recipeDataSource: RecipeDataSource): EditDeleteRecipeContract.Repository {
    override suspend fun updateRecipe(recipe: Recipe): Int {
        return recipeDataSource.updateRecipe(recipe)
    }

    override suspend fun deleteRecipe(recipe: Recipe): Int {
        return recipeDataSource.deleteRecipe(recipe)
    }
}