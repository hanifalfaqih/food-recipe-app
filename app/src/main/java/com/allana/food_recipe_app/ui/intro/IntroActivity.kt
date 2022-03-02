package com.allana.food_recipe_app.ui.intro

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.enum.IntroPage
import com.github.appintro.AppIntro2

class IntroActivity : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        isWizardMode = true
        isSkipButtonEnabled = false

        setIndicatorColor(
            selectedIndicatorColor = ContextCompat.getColor(this, R.color.primary),
            unselectedIndicatorColor = ContextCompat.getColor(this, R.color.unselected_indicator)
        )

        addSlide(IntroPageFragment(IntroPage.ONE))
        addSlide(IntroPageFragment(IntroPage.TWO))
        addSlide(IntroPageFragment(IntroPage.THREE))
    }
}