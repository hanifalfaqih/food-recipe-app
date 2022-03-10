package com.allana.food_recipe_app.ui.main.detail

import com.allana.food_recipe_app.data.base.arch.BaseContract

interface DetailActivityContract {
    interface View: BaseContract.BaseView {
        fun getIntentData()
    }

    interface ViewModel : BaseContract.BaseViewModel

    interface Repository : BaseContract.BaseRepository
}