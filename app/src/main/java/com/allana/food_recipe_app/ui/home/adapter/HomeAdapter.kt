package com.allana.food_recipe_app.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allana.food_recipe_app.data.datasource.RecipeDataSource
import com.allana.food_recipe_app.databinding.ItemRecipeBinding
import com.allana.food_recipe_app.data.model.Recipe
import com.allana.food_recipe_app.ui.home.RecyclerViewClickListener
import com.bumptech.glide.Glide

class HomeAdapter(var context: Context) :
    RecyclerView.Adapter<HomeAdapter.HomeViewModel>() {

    private var items: List<Recipe> = ArrayList()
    var listener: RecyclerViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewModel {
        val binding = ItemRecipeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewModel(binding)
    }

    override fun onBindViewHolder(holder: HomeViewModel, position: Int) {
        holder.bindView(items[position])
        holder.binding.ivFood.setOnClickListener {
            listener?.onItemClicked(it, items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    fun submitList(item: List<Recipe>) {
        items = item
    }

    class HomeViewModel(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Recipe) {
            with(item) {

                Glide.with(itemView)
                    .load(item.recipeImage)
                    .into(binding.ivFood)

                binding.tvCategory.text = item.recipeCategory
            }
        }

    }
}