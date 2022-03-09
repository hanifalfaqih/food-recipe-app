package com.allana.food_recipe_app.ui.main.form.editdelete

import androidx.lifecycle.MutableLiveData
import com.allana.food_recipe_app.data.base.arch.BaseContract
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Recipe

interface EditDeleteRecipeContract {
    interface View : BaseContract.BaseView {
        fun getIntentData()
        fun showToast(msg: String)
    }

    interface ViewModel: BaseContract.BaseViewModel {
        fun updateRecipe(recipe: Recipe)
        fun deleteRecipe(recipe: Recipe)
        fun getRecipeResultLiveData(): MutableLiveData<Pair<String, Resource<Number>>>
    }

    interface Repository: BaseContract.BaseRepository {
        suspend fun updateRecipe(recipe: Recipe): Int
        suspend fun deleteRecipe(recipe: Recipe): Int
    }
}