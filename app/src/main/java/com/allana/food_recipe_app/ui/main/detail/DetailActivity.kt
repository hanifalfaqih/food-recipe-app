package com.allana.food_recipe_app.ui.main.detail

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.MenuItem
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.data.base.arch.BaseActivity
import com.allana.food_recipe_app.data.base.arch.GenericViewModelFactory
import com.allana.food_recipe_app.data.local.room.RecipeDatabase
import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSourceImpl
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import com.allana.food_recipe_app.databinding.ActivityDetailBinding
import com.allana.food_recipe_app.ui.main.form.editdelete.EditDeleteRecipeActivity
import com.bumptech.glide.Glide

class DetailActivity :
    BaseActivity<ActivityDetailBinding, DetailActivityViewModel>(ActivityDetailBinding::inflate),
    DetailActivityContract.View {

    private var recipe: Recipe? = null
    private var category: Category? = null

    companion object{
        private const val INTENT_RECIPE_DATA_DETAIL = "INTENT_RECIPE_DATA"
        private const val INTENT_CATEGORY_DATA_DETAIL = "INTENT_CATEGORY_DATA"

        @JvmStatic
        fun startActivityToDetail(context: Context?, recipe: Recipe? = null, category: Category?){
            val intent = Intent(context, DetailActivity::class.java)
            recipe?.let {
                intent.putExtra(INTENT_RECIPE_DATA_DETAIL, recipe)
                intent.putExtra(INTENT_CATEGORY_DATA_DETAIL, category)
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
        category = intent.getParcelableExtra(INTENT_CATEGORY_DATA_DETAIL)
    }

    override fun initViewModel(): DetailActivityViewModel {
        val repository = DetailActivityRepository(
            RecipeDataSourceImpl(RecipeDatabase.getInstance(this).recipeDao()))
        return GenericViewModelFactory(DetailActivityViewModel(repository)).create(
            DetailActivityViewModel::class.java)
    }

//    override fun observeData() {
//        super.observeData()
//        getViewModel().getResultRecipeLiveData().observe(this){ resource ->
//            when(resource){
//                is Resource.Success -> {
//                    Log.d(TAG, "success")
//                    allCategory = resource.data?.second
//                }
//                else -> {
//                    Log.d(TAG, "success")
//                }
//            }
//        }
//    }

    private fun initializeRecipe(){
        recipe?.let { recipe ->
            category?.let{
                getViewBinding().tvCategoryDetail.text = it.categoryName
            }

            Glide.with(this@DetailActivity)
                .load(recipe.recipeImage)
                .into(getViewBinding().ivDetailRecipe)
            getViewBinding().tvTitleDetail.text = recipe.recipeName.toString().uppercase()
            getViewBinding().tvTitleIngredientsDetail.text = getString(R.string.text_title_ingredients)
            getViewBinding().tvIngredientDetail.text = recipe.recipeIngredient
            getViewBinding().tvTitleInstructionsRecipe.text = getString(R.string.text_title_instruction)
            getViewBinding().tvInstructionDetail.text = recipe.recipeInstruction
        }
    }

    private fun setClickListeners(){
        getViewBinding().btnUpdateDetail.setOnClickListener {
            EditDeleteRecipeActivity.startActivityToEditDelete(this, recipe)
        }
    }

}