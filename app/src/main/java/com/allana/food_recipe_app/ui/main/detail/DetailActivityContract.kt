package com.allana.food_recipe_app.ui.main.detail

import androidx.lifecycle.MutableLiveData
import com.allana.food_recipe_app.data.base.arch.BaseContract
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe

interface DetailActivityContract {
    interface View: BaseContract.BaseView {
        fun getIntentData()
    }

    interface ViewModel: BaseContract.BaseViewModel {
        fun getResultRecipeLiveData(): MutableLiveData<Resource<Pair<List<Recipe>, List<Category>>>>
        fun showRecipe(idRecipe: Int): List<Recipe>
    }

    interface Repository: BaseContract.BaseRepository {
        suspend fun showRecipe(idRecipe: Int): List<Recipe>
        suspend fun getAllCategory(): List<Category>
    }
}