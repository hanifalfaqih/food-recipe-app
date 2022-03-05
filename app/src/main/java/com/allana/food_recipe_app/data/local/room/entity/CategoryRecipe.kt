package com.allana.food_recipe_app.data.local.room.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryRecipe(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "idCategory",
        entityColumn = "idCategoryRecipe"
    )
    val recipe: List<Recipe>
)
