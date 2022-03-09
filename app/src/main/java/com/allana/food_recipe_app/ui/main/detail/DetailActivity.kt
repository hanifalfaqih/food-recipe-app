package com.allana.food_recipe_app.ui.main.detail

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.MenuItem
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.data.base.arch.BaseActivity
import com.allana.food_recipe_app.data.base.arch.GenericViewModelFactory
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.RecipeDatabase
import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSourceImpl
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import com.allana.food_recipe_app.databinding.ActivityDetailBinding
import com.allana.food_recipe_app.ui.home.detail.DetailActivityContract
import com.allana.food_recipe_app.ui.home.detail.DetailActivityRepository
import com.allana.food_recipe_app.ui.home.detail.DetailActivityViewModel
import com.allana.food_recipe_app.ui.main.form.editdelete.EditDeleteRecipeActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

class DetailActivity :
    BaseActivity<ActivityDetailBinding, DetailActivityViewModel>(ActivityDetailBinding::inflate),
    DetailActivityContract.View {

    private var recipe: Recipe? = null
    private var category: Category? = null

    companion object{
        private val TAG = DetailActivity::class.simpleName
        private const val INTENT_RECIPE_DATA_DETAIL = "INTENT_RECIPE_DATA"

        @JvmStatic
        fun startActivityToDetail(context: Context?, recipe: Recipe? = null){
            val intent = Intent(context, DetailActivity::class.java)
            recipe?.let {
                intent.putExtra(INTENT_RECIPE_DATA_DETAIL, recipe)
            }
            context?.startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

     override fun initView(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.text_detail_recipe)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF672C")))

         getIntentData()
         initializeRecipe()
         setClickListeners()
    }

    override fun getIntentData() {
        recipe = intent.getParcelableExtra(INTENT_RECIPE_DATA_DETAIL)
    }

    override fun initViewModel(): DetailActivityViewModel {
        val repository = DetailActivityRepository(
            RecipeDataSourceImpl(RecipeDatabase.getInstance(this).recipeDao()))
        return GenericViewModelFactory(DetailActivityViewModel(repository)).create(
            DetailActivityViewModel::class.java)
    }

    override fun observeData() {
        super.observeData()
        getViewModel().getResultRecipeLiveData().observe(this){ resource ->
            when(resource){
                is Resource.Success -> {
                    Log.d(TAG, "success")
                }
                else -> {
                    Log.d(TAG, "success")
                }
            }
        }
    }

    private fun initializeRecipe(){
        recipe?.let {
            Glide.with(this@DetailActivity)
                .load(it.recipeImage)
                .into(getViewBinding().ivDetailRecipe)
            getViewBinding().tvTitleDetail.text = recipe?.recipeName
            getViewBinding().tvCategoryDetail.text = category?.categoryName
            getViewBinding().tvTitleIngredientsDetail.text = getString(R.string.text_title_ingredients)
            getViewBinding().tvIngredientDetail.text = recipe?.recipeIngredient
            getViewBinding().tvTitleInstructionsRecipe.text = getString(R.string.text_title_instruction)
            getViewBinding().tvInstructionDetail.text = recipe?.recipeInstruction
        }
    }

    private fun setClickListeners(){
        getViewBinding().btnUpdateDetail.setOnClickListener {
            EditDeleteRecipeActivity.startActivityToEditDelete(this, recipe)
        }
    }

}