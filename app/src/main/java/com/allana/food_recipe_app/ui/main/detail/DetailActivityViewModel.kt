package com.allana.food_recipe_app.ui.home.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allana.food_recipe_app.data.base.arch.BaseViewModelImpl
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailActivityViewModel(
    private val repository: DetailActivityContract.Repository
    ): DetailActivityContract.ViewModel, BaseViewModelImpl() {

    private val resultRecipeLiveData = MutableLiveData<Resource<List<Recipe>>>()

    override fun showRecipe(idRecipe: Int): List<Recipe> {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.showRecipe(idRecipe)
                viewModelScope.launch(Dispatchers.Main) {
                    if (result == repository){
                        resultRecipeLiveData.value = Resource.Success(result)
                    } else {
                        resultRecipeLiveData.value = Resource.Error("", result)
                    }
                }
            } catch (ex: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    resultRecipeLiveData.value = Resource.Error(ex.message.toString())
                }
            }
        }
        return showRecipe(idRecipe)
    }

    override fun getResultRecipeLiveData(): MutableLiveData<Resource<List<Recipe>>> = resultRecipeLiveData
}