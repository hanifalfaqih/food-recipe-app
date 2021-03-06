package com.allana.food_recipe_app.ui.main.form.add

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.MenuItem
import android.widget.Toast
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.data.base.arch.BaseActivity
import com.allana.food_recipe_app.data.base.arch.GenericViewModelFactory
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.RecipeDatabase
import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSourceImpl
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import com.allana.food_recipe_app.databinding.ActivityAddRecipeBinding

class AddRecipeActivity: BaseActivity<ActivityAddRecipeBinding, AddRecipeViewModel>(ActivityAddRecipeBinding::inflate), AddRecipeContract.View {

    private var recipe: Recipe? = null

    override fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.text_action_bar_add_activity)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF672C")))
        setClickListener()
    }

    private fun setClickListener() {
        getViewBinding().btnSaveRecipe.setOnClickListener {
            addRecipe()
        }
    }

    override fun observeData() {
        super.observeData()
        getViewModel().getRecipeResultLiveData().observe(this) {
            when (it) {
                is Resource.Success -> {
                    showToast(getString(R.string.text_success_add_recipe))
                }
                else -> {
                    showToast(getString(R.string.text_failed_add_recipe))
                }
            }
            this.finish()
        }
    }

    private fun addRecipe() {
        if (validateForm()) {
            recipe = Recipe(
                recipeName = getViewBinding().etRecipeName.text.toString(),
                recipeIngredient = getViewBinding().etRecipeIngredients.text.toString(),
                recipeInstruction = getViewBinding().etRecipeInstructions.text.toString(),
                recipeImage = getViewBinding().etRecipeInputLink.text.toString(),
                idCategoryRecipe = getViewBinding().spinnerCategories.selectedItemPosition
            )
            recipe?.let { getViewModel().insertRecipe(it) }
        }
    }

    private fun validateForm(): Boolean {
        val recipeImage = getViewBinding().etRecipeInputLink.text.toString()
        val recipeName = getViewBinding().etRecipeName.text.toString()
        val recipeIngredients = getViewBinding().etRecipeIngredients.text.toString()
        val recipeInstructions = getViewBinding().etRecipeInstructions.text.toString()
        val isFormValid: Boolean

        when {
            recipeImage.isEmpty() -> {
                isFormValid = false
                getViewBinding().etRecipeInputLink.error = getString(R.string.text_error_et_recipe_image)
            }
            recipeName.isEmpty() -> {
                isFormValid = false
                getViewBinding().etRecipeName.error = getString(R.string.text_error_et_recipe_name)
            }
            recipeIngredients.isEmpty() -> {
                isFormValid = false
                getViewBinding().etRecipeIngredients.error = getString(R.string.text_error_et_recipe_ingredients)
            }
            recipeInstructions.isEmpty() -> {
                isFormValid = false
                getViewBinding().etRecipeInstructions.error = getString(R.string.text_error_et_recipe_instructions)
            }
            else -> {
                isFormValid = true
            }
        }
        return isFormValid
    }

    override fun initViewModel(): AddRecipeViewModel {
        val repository = AddRecipeRepository(
            RecipeDataSourceImpl(RecipeDatabase.getInstance(this).recipeDao()),
        )
        return GenericViewModelFactory(AddRecipeViewModel(repository)).create(
            AddRecipeViewModel::class.java
        )
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

}

