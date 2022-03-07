package com.allana.food_recipe_app.ui.home.form.editdelete

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allana.food_recipe_app.data.base.arch.BaseViewModelImpl
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditDeleteRecipeViewModel(private val repository: EditDeleteRecipeRepository): BaseViewModelImpl(), EditDeleteRecipeContract.ViewModel {

    private val editDeleteRecipeResultLiveData = MutableLiveData<Resource<Number>>()

    override fun updateRecipe(recipe: Recipe) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val insertedRowId = repository.updateRecipe(recipe)
                viewModelScope.launch(Dispatchers.Main) {
                    if (insertedRowId > 0) {
                        editDeleteRecipeResultLiveData.value = Resource.Success(insertedRowId)
                    } else {
                        editDeleteRecipeResultLiveData.value = Resource.Error("", insertedRowId)
                    }
                }
            } catch (error: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    editDeleteRecipeResultLiveData.value = Resource.Error(error.message.toString())
                }
            }
        }
    }

    override fun deleteRecipe(recipe: Recipe) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val insertedRowId = repository.deleteRecipe(recipe)
                viewModelScope.launch(Dispatchers.Main) {
                    if (insertedRowId > 0) {
                        editDeleteRecipeResultLiveData.value = Resource.Success(insertedRowId)
                    } else {
                        editDeleteRecipeResultLiveData.value = Resource.Error("", insertedRowId)
                    }
                }
            } catch (error: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    editDeleteRecipeResultLiveData.value = Resource.Error(error.message.toString())
                }
            }
        }
    }

    override fun getRecipeResultLiveData(): MutableLiveData<Resource<Number>> = editDeleteRecipeResultLiveData
}