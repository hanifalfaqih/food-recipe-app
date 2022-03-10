package com.allana.food_recipe_app.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.allana.food_recipe_app.data.local.room.dao.RecipeDao
import com.allana.food_recipe_app.data.local.room.entity.Category
import com.allana.food_recipe_app.data.local.room.entity.Recipe
import com.allana.food_recipe_app.data.local.room.entity.populateData
import java.util.concurrent.Executors


@Database(entities = [Category::class, Recipe::class], version = 1, exportSchema = true)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {
        private const val DB_NAME = "recipe_db"


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
                        Executors.newSingleThreadScheduledExecutor().execute {
                            getInstance(context).recipeDao().insertAllCategory(populateData())
                        }
                    }
                }).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

