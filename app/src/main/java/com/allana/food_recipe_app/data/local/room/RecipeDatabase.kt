package com.allana.food_recipe_app.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.allana.food_recipe_app.data.local.room.dao.RecipeDao
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import java.util.concurrent.Executors


@Database(entities = [Category::class, Recipe::class], version = 1, exportSchema = true)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        private const val DB_NAME = "recipe_db"
        val prepopulateData = listOf(
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
            Category(13, "Vegetarian"))

        @Volatile
        private var INSTANCE: RecipeDatabase? = null
        fun getInstance(context: Context): RecipeDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeDatabase::class.java,
                    DB_NAME
                ).addCallback(object: Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadExecutor().execute {
                            getInstance(context).recipeDao().insertAllCategory(prepopulateData)
                        }
                    }
                })
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

