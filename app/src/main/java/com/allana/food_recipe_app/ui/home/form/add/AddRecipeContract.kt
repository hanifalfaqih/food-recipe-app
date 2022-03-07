package com.allana.food_recipe_app.ui.home.form.add

import androidx.lifecycle.MutableLiveData
import com.allana.food_recipe_app.data.base.arch.BaseContract
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Recipe

interface AddRecipeContract {

    interface View : BaseContract.BaseView {
        fun showToast(msg: String)
    }

    interface ViewModel: BaseContract.BaseViewModel {
        fun insertRecipe(recipe: Recipe)
        fun getRecipeResultLiveData(): MutableLiveData<Resource<Number>>
    }

    interface Repository: BaseContract.BaseRepository {
        suspend fun insertRecipe(recipe: Recipe): Long
    }
}