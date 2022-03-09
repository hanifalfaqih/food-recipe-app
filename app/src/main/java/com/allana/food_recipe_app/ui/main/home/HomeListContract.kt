package com.allana.food_recipe_app.ui.main.home

import androidx.lifecycle.MutableLiveData
import com.allana.food_recipe_app.data.base.arch.BaseContract
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.CategoryRecipe
import com.allana.food_recipe_app.data.local.room.entity.Recipe

interface HomeListContract {
    interface View : BaseContract.BaseView {
        fun setupRecyclerView()
        fun setupSwipeRefresh()
        fun setListData(data: Pair<List<Recipe>, List<Category>>)
        fun getData()
    }

    interface ViewModel : BaseContract.BaseViewModel {
        fun getAllRecipe()
        fun getRecipeLiveData(): MutableLiveData<Resource<Pair<List<Recipe>, List<Category>>>>
    }

    interface Repository : BaseContract.BaseRepository {
        suspend fun getAllRecipe(): List<Recipe>

        suspend fun getAllCategory(): List<Category>
    }
}