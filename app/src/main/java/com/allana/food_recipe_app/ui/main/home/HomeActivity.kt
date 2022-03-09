package com.allana.food_recipe_app.ui.main.home

import android.content.Intent
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.allana.food_recipe_app.R
import com.allana.food_recipe_app.data.base.arch.BaseActivity
import com.allana.food_recipe_app.data.base.arch.GenericViewModelFactory
import com.allana.food_recipe_app.data.base.model.Resource
import com.allana.food_recipe_app.databinding.ActivityHomeBinding
import com.allana.food_recipe_app.data.local.room.RecipeDatabase
import com.allana.food_recipe_app.data.local.room.datasource.RecipeDataSourceImpl
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import com.allana.food_recipe_app.ui.main.adapter.HomeAdapter
import com.allana.food_recipe_app.ui.main.detail.DetailActivity
import com.allana.food_recipe_app.ui.main.form.add.AddRecipeActivity

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(ActivityHomeBinding::inflate),
    HomeListContract.View {

    private lateinit var adapter: HomeAdapter

    override fun initView() {
        setupRecyclerView()
        setupSwipeRefresh()

        getViewBinding().fabAdd.setOnClickListener {
            startActivity(Intent(this, AddRecipeActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    override fun initViewModel(): HomeViewModel {
        val dataSource = RecipeDataSourceImpl(RecipeDatabase.getInstance(this).recipeDao())
        val repository = HomeRepository(dataSource)
        return GenericViewModelFactory(HomeViewModel(repository)).create(HomeViewModel::class.java)
    }

    override fun setupRecyclerView() {
        // TODO("add intent, fixing recyclerView")
        adapter = HomeAdapter {
            DetailActivity.startActivityToDetail(this, it)
        }
        getViewBinding().rvCategory.apply {
            layoutManager = GridLayoutManager(this@HomeActivity, 2)
            adapter = this@HomeActivity.adapter
        }
    }

    override fun setupSwipeRefresh() {
        getViewBinding().srlRecipe.setOnRefreshListener {
            getData()
            getViewBinding().srlRecipe.isRefreshing = false
        }
    }

    override fun setListData(data: List<Recipe>) {
        adapter.setItems(data)
    }

    override fun getData() {
        getViewModel().getAllRecipe()
    }

    override fun showLoading(isVisible: Boolean) {
        super.showLoading(isVisible)
        getViewBinding().layoutWelcome.progressBar.isVisible = isVisible
    }

    override fun showContent(isVisible: Boolean) {
        super.showContent(isVisible)
        getViewBinding().rvCategory.isVisible = isVisible
    }

    override fun showError(isErrorEnabled: Boolean, msg: String?) {
        getViewBinding().layoutWelcome.tvMessage.isVisible = isErrorEnabled
        getViewBinding().layoutWelcome.tvMessage.text = msg
        getViewBinding().layoutWelcome.ivWelcome.isVisible = isErrorEnabled
    }

    override fun observeData() {
        getViewModel().getRecipeLiveData().observe(this) {
            when (it) {
                is Resource.Loading -> {
                    showLoading(true)
                    showError(false, null)
                    showContent(false)
                }
                is Resource.Success -> {
                    showLoading(false)
                    it.data?.let { recipes ->
                        if (recipes.isEmpty()) {
                            showError(true, getString(R.string.text_welcome))
                            showContent(false)
                        } else {
                            showError(false, null)
                            showContent(true)
                            setListData(recipes)
                        }
                    }
                }
                is Resource.Error -> {
                    showLoading(false)
                    showError(true, it.message)
                    showContent(false)
                }
            }
        }
    }

    //    private lateinit var binding: ActivityHomeBinding
//    private lateinit var homeAdapter: HomeAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityHomeBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        supportActionBar?.hide()
//
//        initView()
//        setupSwipeRefresh()
//        setupRecycler()
//        setupAdapter()
//    }
//
//    private fun initView() {
//        binding.fabAdd.setOnClickListener {
//            startActivity(Intent(this, AddRecipeActivity::class.java))
////            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    override fun setupSwipeRefresh() {
//        binding.srlRecipe.setOnRefreshListener {
//            getData()
//            binding.srlRecipe.isRefreshing = false
//        }
//    }
//
//    private fun getData() {
//
//    }
//
//    override fun setupRecycler() {
//        binding.rvCategory.layoutManager = GridLayoutManager(applicationContext, 2)
//        homeAdapter = HomeAdapter(applicationContext)
//        binding.rvCategory.adapter = homeAdapter
//        homeAdapter.listener = this
//    }
//
//    private fun setupAdapter() {
//        val data = RecipeDataSource.createDataSet()
//        homeAdapter.submitList(data)
//    }
//
//    override fun onItemClicked(view: View, recipe: Recipe) {
//        startActivity(Intent(this, DetailActivity::class.java))
//    }
}