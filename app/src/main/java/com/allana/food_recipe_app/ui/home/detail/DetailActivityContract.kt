package com.allana.food_recipe_app.ui.home.detail

import androidx.lifecycle.MutableLiveData
import com.allana.food_recipe_app.data.base.arch.BaseContract
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Recipe

interface DetailActivityContract {
    interface View: BaseContract.BaseView {
        fun getIntentData()
    }

    interface ViewModel: BaseContract.BaseViewModel {
        fun getResultRecipeLiveData(): MutableLiveData<Pair<String, Resource<Number>>>
        fun updateRecipe(recipe: Recipe)
    }

    interface Repository: BaseContract.BaseRepository {
        suspend fun updateRecipe(recipe: Recipe): Int
    }
}