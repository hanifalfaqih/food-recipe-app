package com.allana.food_recipe_app.ui.intro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.data.local.preference.UserPreference
import com.allana.food_recipe_app.ui.main.home.HomeActivity
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroCustomLayoutFragment.Companion.newInstance

class IntroActivity : AppIntro2() {

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        isSkipButtonEnabled = false

        setIndicatorColor(
            selectedIndicatorColor = ContextCompat.getColor(this, R.color.primary),
            unselectedIndicatorColor = ContextCompat.getColor(this, R.color.unselected_indicator)
        )

        addSlide(newInstance(R.layout.layout_intro_one))
        addSlide(newInstance(R.layout.layout_intro_two))
        addSlide(newInstance(R.layout.layout_intro_three))
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        isFirstAppOpen()
    }

    private fun isFirstAppOpen() {
        UserPreference(this).isAppOpenedFirstTime = false
    }
}