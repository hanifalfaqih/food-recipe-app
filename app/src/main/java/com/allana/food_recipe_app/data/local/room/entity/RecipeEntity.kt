package com.allana.food_recipe_app.data.local.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val idRecipe: Int = 0,
    @ColumnInfo(name = "idCategoryRecipe")
    var idCategoryRecipe: Int,
    @ColumnInfo(name = "recipeName")
    var recipeName: String?,
    @ColumnInfo(name = "recipeIngredient")
    var recipeIngredient: String?,
    @ColumnInfo(name = "recipeInstruction")
    var recipeInstruction: String?,
    @ColumnInfo(name = "recipeImage")
    var recipeImage: String?,
) : Parcelable

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey
    val idCategory: Int,
    @ColumnInfo(name = "categoryName")
    var categoryName: String?,
)

fun populateData(): List<Category> {
    return listOf(
        Category(0, "Beef"),
        Category(1, "Breakfast"),
        Category(2, "Chicken"),
        Category(3, "Desert"),
        Category(4, "Goat"),
        Category(5, "Lamb"),
        Category(6, "Miscellaneous"),
        Category(7, "Pasta"),
        Category(8, "Pork"),
        Category(9, "Seafood"),
        Category(10, "Side"),
        Category(11, "Starter"),
        Category(12, "Vegan"),
        Category(13, "Vegetarian")
    )
}
