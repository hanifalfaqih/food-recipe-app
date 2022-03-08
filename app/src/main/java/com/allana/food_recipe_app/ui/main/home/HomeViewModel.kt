package com.allana.food_recipe_app.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allana.food_recipe_app.data.base.arch.BaseViewModelImpl
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.CategoryRecipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(private val repository: HomeRepository) : BaseViewModelImpl(),
    HomeListContract.ViewModel {

    private val recipes = MutableLiveData<Resource<List<CategoryRecipe>>>()

    override fun getAllRecipe() {
        recipes.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delay(2000)
                val recipe = repository.getAllRecipe()
                viewModelScope.launch(Dispatchers.Main) {
                    recipes.value = Resource.Success(recipe)
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    recipes.value = Resource.Error(e.message.orEmpty())
                }
            }
        }
    }

    override fun getRecipeLiveData(): MutableLiveData<Resource<List<CategoryRecipe>>> = recipes
}