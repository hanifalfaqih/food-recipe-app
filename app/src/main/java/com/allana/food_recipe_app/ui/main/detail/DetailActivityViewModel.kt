package com.allana.food_recipe_app.ui.main.detail

import com.allana.food_recipe_app.data.base.arch.BaseViewModelImpl

class DetailActivityViewModel(
    private val repository: DetailActivityContract.Repository
) : DetailActivityContract.ViewModel, BaseViewModelImpl()