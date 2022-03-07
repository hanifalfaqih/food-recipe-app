package com.allana.food_recipe_app.ui.home.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allana.food_recipe_app.data.base.arch.BaseViewModelImpl
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import com.allana.food_recipe_app.utils.CommonConstant.UPDATE_OPERATION
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailActivityViewModel(
    private val repository: DetailActivityContract.Repository
    ): DetailActivityContract.ViewModel, BaseViewModelImpl() {

    private val resultRecipeLiveData = MutableLiveData<Pair<String, Resource<Number>>>()

    override fun updateRecipe(recipe: Recipe) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.updateRecipe(recipe)
                viewModelScope.launch(Dispatchers.Main) {
                    if (result > 0) {
                        resultRecipeLiveData.value = Pair(UPDATE_OPERATION, Resource.Success(result))
                    } else {
                        resultRecipeLiveData.value = Pair(UPDATE_OPERATION, Resource.Error("", result))
                    }
                }
            } catch (ex: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    resultRecipeLiveData.value = Pair(UPDATE_OPERATION, Resource.Error(ex.message.orEmpty()))
                }
            }
        }
    }

    override fun getResultRecipeLiveData(): MutableLiveData<Pair<String, Resource<Number>>> = resultRecipeLiveData
}