package com.allana.food_recipe_app.data.local.preference;

import android.content.Context
import android.content.SharedPreferences

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class UserPreference(context: Context) {
    private var preference: SharedPreferences = context.getSharedPreferences(NAME, MODE)

    companion object {
        private const val NAME = "FoodRecipe" //app name or else
        private const val MODE = Context.MODE_PRIVATE
        private val PREF_PREF_IS_APP_OPENED_FIRST_TIME =
            Pair("PREF_PREF_IS_APP_OPENED_FIRST_TIME", true)
    }

    var isAppOpenedFirstTime: Boolean
        get() = preference.getBoolean(
            PREF_PREF_IS_APP_OPENED_FIRST_TIME.first,
            PREF_PREF_IS_APP_OPENED_FIRST_TIME.second
        )
        set(value)= preference.edit{
            it.putBoolean(PREF_PREF_IS_APP_OPENED_FIRST_TIME.first, value)
        }

}

private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = edit()
    operation(editor)
    editor.apply()
}

private fun SharedPreferences.delete() {
    edit().clear().apply()
}