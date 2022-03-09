package com.allana.food_recipe_app.ui.main.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.allana.food_recipe_app.data.base.arch.BaseViewModelImpl
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailActivityViewModel(
    private val repository: DetailActivityContract.Repository
    ): DetailActivityContract.ViewModel, BaseViewModelImpl() {

    private val data = MutableLiveData<Resource<Pair<List<Recipe>, List<Category>>>>()

    override fun showRecipe(idRecipe: Int): List<Recipe> {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.showRecipe(idRecipe)
                val category = repository.getAllCategory()
                viewModelScope.launch(Dispatchers.Main) {
                    if (result == repository){
                        data.value = Resource.Success(Pair(result, category))
                    } else {
                        data.value = Resource.Error("", Pair(result, category))
                    }
                }
            } catch (ex: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    data.value = Resource.Error(ex.message.toString())
                }
            }
        }
        return showRecipe(idRecipe)
    }

    override fun getResultRecipeLiveData(): MutableLiveData<Resource<Pair<List<Recipe>, List<Category>>>> = data
}