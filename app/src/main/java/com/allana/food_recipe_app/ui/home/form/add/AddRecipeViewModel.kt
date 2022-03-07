package com.allana.food_recipe_app.ui.home.form.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allana.food_recipe_app.data.base.arch.BaseViewModelImpl
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddRecipeViewModel(private val repository: AddRecipeRepository): BaseViewModelImpl(), AddRecipeContract.ViewModel {

    private val addRecipeResultLiveData = MutableLiveData<Resource<Number>>()

    override fun insertRecipe(recipe: Recipe) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val insertedRowId = repository.insertRecipe(recipe)
                viewModelScope.launch(Dispatchers.Main) {
                    if (insertedRowId > 0) {
                        addRecipeResultLiveData.value = Resource.Success(insertedRowId)
                    } else {
                        addRecipeResultLiveData.value = Resource.Error("", insertedRowId)
                    }
                }
            } catch (error: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    addRecipeResultLiveData.value = Resource.Error(error.message.toString())
                }
            }
        }
    }

    override fun getRecipeResultLiveData(): MutableLiveData<Resource<Number>> = addRecipeResultLiveData
}