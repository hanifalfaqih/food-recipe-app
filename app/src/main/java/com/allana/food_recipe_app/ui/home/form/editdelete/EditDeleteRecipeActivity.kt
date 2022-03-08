package com.allana.food_recipe_app.ui.home.form.editdelete

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.data.base.arch.BaseActivity
import com.allana.food_recipe_app.data.base.arch.GenericViewModelFactory
import com.allana.food_recipe_app.data.local.room.RecipeDatabase
import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSourceImpl
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import com.allana.food_recipe_app.databinding.ActivityEditDeleteRecipeBinding
import com.allana.food_recipe_app.ui.home.detail.DetailActivity.Companion.INTENT_RECIPE_DATA

class EditDeleteRecipeActivity : BaseActivity<ActivityEditDeleteRecipeBinding, EditDeleteRecipeViewModel>(
    ActivityEditDeleteRecipeBinding::inflate), EditDeleteRecipeContract.View{

    private var recipe: Recipe? = null

    override fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.text_action_bar_edit_delete_activity)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF672C")))
        getIntentData()
        initializeRecipe()
        setClickListener()
    }

    private fun setClickListener() {
        getViewBinding().btnUpdateRecipe.setOnClickListener {
            if (validateForm()) {
                updateRecipe()
            }
        }
        getViewBinding().btnDeleteRecipe.setOnClickListener {
            recipe?.let {
                getViewModel().deleteRecipe(it)
            }
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

    private fun updateRecipe() {
        recipe = Recipe(
            recipeName = getViewBinding().etRecipeName.text.toString(),
            recipeIngredient = getViewBinding().etRecipeIngredients.text.toString(),
            recipeInstruction = getViewBinding().etRecipeInstructions.text.toString(),
            recipeImage = getViewBinding().etRecipeInputLink.text.toString(),
            idCategoryRecipe = getViewBinding().spinnerCategories.selectedItemPosition
        )
        recipe?.let {
            getViewModel().updateRecipe(it)
        }
    }

    private fun initializeRecipe() {
        recipe?.let {
            getViewBinding().etRecipeInputLink.setText(it.recipeImage)
            getViewBinding().etRecipeName.setText(it.recipeImage)
            getViewBinding().spinnerCategories.setSelection(it.idCategoryRecipe)
            getViewBinding().etRecipeIngredients.setText(it.recipeIngredient)
            getViewBinding().etRecipeInstructions.setText(it.recipeInstruction)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) handleOnBackPressedCallback()
        return super.onOptionsItemSelected(item)
    }

    override fun initViewModel(): EditDeleteRecipeViewModel {
        val repository = EditDeleteRecipeRepository(
            RecipeDataSourceImpl(RecipeDatabase.getInstance(this).recipeDao()),
        )
        return GenericViewModelFactory(EditDeleteRecipeViewModel(repository)).create(
            EditDeleteRecipeViewModel::class.java
        )
    }

    private fun showAlertDialog() {
        val dialogTitle = getString(R.string.text_alert_dialog_title)
        val dialogMessage = getString(R.string.text_alert_dialog_message)
        val alertDialogBuilder = AlertDialog.Builder(this)
        with(alertDialogBuilder) {
            setTitle(dialogTitle)
            setMessage(dialogMessage)
            setCancelable(false)
            setPositiveButton(getString(R.string.text_alert_dialog_title)) { _, _ ->
                finish()
            }
            setNegativeButton(getString(R.string.text_negative_button)) { dialog, _ ->
                dialog.cancel() }
        }
        alertDialogBuilder.create().show()
    }

    override fun getIntentData() {
        recipe = intent.getParcelableExtra(INTENT_RECIPE_DATA)
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun handleOnBackPressedCallback() {
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() { showAlertDialog() }
        }
        this.onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

}