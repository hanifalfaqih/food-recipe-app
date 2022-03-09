package com.allana.food_recipe_app.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import com.allana.food_recipe_app.data.local.room.entity.populateData
import com.allana.food_recipe_app.databinding.ItemRecipeBinding
import com.bumptech.glide.Glide

class HomeAdapter(private val itemClick: (Recipe) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var items: MutableList<Recipe> = mutableListOf()

    fun setItems(items: List<Recipe>) {
        clearItems()
        addItems(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<Recipe>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemRecipeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

    class HomeViewHolder(
        private val binding: ItemRecipeBinding,
        val itemClick: (Recipe) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: Recipe) {
            with(item) {
                val categories = ArrayList<Category>()
                var categoryName: String? = null

                for (category in categories) {
                    if (category.idCategory == item.idCategoryRecipe) {
                        category.categoryName = categoryName
                    }
                }
                Glide.with(itemView)
                    .load(item.recipeImage)
                    .into(binding.ivFood)

                binding.tvCategory.text = categoryName

                itemView.setOnClickListener {
                    itemClick(this)
                }
            }
        }
    }
}