package com.allana.food_recipe_app.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allana.food_recipe_app.data.base.arch.BaseViewModelImpl
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : BaseViewModelImpl(),
    HomeListContract.ViewModel {

    private val data = MutableLiveData<Resource<Pair<List<Recipe>, List<Category>>>>()

    override fun getAllRecipe() {
        data.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delay(2000)
                val recipe = repository.getAllRecipe()
                val category = repository.getAllCategory()
                viewModelScope.launch(Dispatchers.Main) {
                    data.value = Resource.Success(Pair(recipe, category))
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    data.value = Resource.Error(e.message.orEmpty())
                }
            }
        }
    }

    override fun getRecipeLiveData(): MutableLiveData<Resource<Pair<List<Recipe>, List<Category>>>> = data

}