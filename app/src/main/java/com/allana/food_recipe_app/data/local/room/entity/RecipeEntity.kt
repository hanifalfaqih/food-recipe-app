package com.allana.food_recipe_app.data.local.room.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val idRecipe: Int = 0,
    @ColumnInfo(name = "idCategoryRecipe")
    var idCategoryRecipe: Int = 0,
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
    @PrimaryKey(autoGenerate = true)
    val idCategory: Int = 0,
    @ColumnInfo(name = "categoryName")
    var categoryName: String?,
)
