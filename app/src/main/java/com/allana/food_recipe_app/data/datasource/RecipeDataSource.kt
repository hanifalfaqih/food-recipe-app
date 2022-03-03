package com.allana.food_recipe_app.data.datasource

import com.allana.food_recipe_app.data.model.Recipe

class RecipeDataSource {
    companion object {
        fun createDataSet(): ArrayList<Recipe> {
            val list = ArrayList<Recipe>()

            list.add(
                Recipe(
                    "Chicken",
                    "https://cdn.shopify.com/s/files/1/2615/5150/products/1-roast-chicken-19c-P9150019_1200x1200.jpg?v=1574085625"
                )
            )
            list.add(
                Recipe(
                    "Beef",
                    "https://www.virginwines.co.uk/hub/wp-content/uploads/Beef-70-2560x1440.jpeg"
                )
            )
            list.add(
                Recipe(
                    "Pasta",
                    "https://www.italianfoodforever.com/wp-content/uploads/2019/07/bursttomatopasta1-480x480.jpg"
                )
            )
            list.add(
                Recipe(
                    "Vegan",
                    "https://www.home-dzine.co.za/2018/sep/45.jpg"
                )
            )
            list.add(
                Recipe(
                    "Breakfast",
                    "https://blog.williams-sonoma.com/wp-content/uploads/2017/02/Eggs-Benny-1.jpg"
                )
            )
            list.add(
                Recipe(
                    "Seafood",
                    "https://cdn.shopify.com/s/files/1/1968/5479/products/shutterstock_489288454_large.png?v=1581137357"
                )
            )
            list.add(
                Recipe(
                    "Side",
                    "https://giant.sg/assets/easyimage/2/29d6103e48fe3628b76350b84574fa2a.jpg"
                )
            )
            list.add(
                Recipe(
                    "Lamb",
                    "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/lamb-balti-158dcba.jpg?quality=90&resize=440,400"
                )
            )
            list.add(
                Recipe(
                    "Goat",
                    "https://1.bp.blogspot.com/-mFqB2uvWbBw/XX2f7XTT5uI/AAAAAAAAAaA/wJ-VTegA-BIKoFJjKTfV2OQayBGiJyqLgCLcBGAsYHQ/s1600/Goat%2BSatay.png"
                )
            )
            list.add(
                Recipe(
                    "Dessert",
                    "https://i.ytimg.com/vi/hy0nhGQPlqw/hqdefault.jpg"
                )
            )
            return list
        }
    }
}