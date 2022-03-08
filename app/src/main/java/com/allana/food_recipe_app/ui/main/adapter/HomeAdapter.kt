package com.allana.food_recipe_app.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allana.food_recipe_app.data.local.room.entity.CategoryRecipe
import com.allana.food_recipe_app.databinding.ItemRecipeBinding

class HomeAdapter(private val itemClick: (CategoryRecipe)) :
    RecyclerView.Adapter<HomeAdapter.HomeViewModel>() {

    private var items: MutableList<CategoryRecipe> = mutableListOf()

    fun setItems(items: List<CategoryRecipe>) {
        clearItems()
        addItems(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<CategoryRecipe>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewModel {
        val binding = ItemRecipeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewModel(binding, itemClick)
    }

    override fun onBindViewHolder(holder: HomeViewModel, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

    class HomeViewModel(
        private val binding: ItemRecipeBinding,
        val itemClick: CategoryRecipe
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: CategoryRecipe) {
            with(item) {

//                Glide.with(itemView)
//                    .load(item.recipe.)
//                    .into(binding.ivFood)

                binding.tvCategory.text = item.category.categoryName
                itemView.setOnClickListener { itemClick }
            }
        }
    }
}