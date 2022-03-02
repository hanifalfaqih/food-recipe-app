package com.allana.food_recipe_app.ui.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.databinding.FragmentIntroPageBinding
import com.allana.food_recipe_app.enum.IntroPage

class IntroPageFragment(private val introPage: IntroPage) : Fragment() {

    private lateinit var binding: FragmentIntroPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        when(introPage) {
            IntroPage.ONE -> {
                binding.tvTitleIntro.text = getString(R.string.text_title_intro_one)
                binding.tvDescIntro.text = getString(R.string.text_desc_intro_one)
                binding.ivIntro.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_intro_one
                    )
                )
            }
            IntroPage.TWO -> {
                binding.tvTitleIntro.text = getString(R.string.text_title_intro_two)
                binding.tvDescIntro.text = getString(R.string.text_desc_intro_two)
                binding.ivIntro.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_intro_second
                    )
                )
            }
            IntroPage.THREE -> {
                binding.tvTitleIntro.text = getString(R.string.text_title_intro_three)
                binding.tvDescIntro.text = getString(R.string.text_desc_intro_three)
                binding.ivIntro.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_intro_three
                    )
                )
            }
        }
    }
}