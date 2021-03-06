package es.fron99.Foodorganize.Dao.Model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class MenuWithFoods(
        @Embedded var menu: MenuDao,
        @Relation(
                parentColumn = "idMenu",
                entityColumn = "idFood",
                associateBy = Junction(MenusFoodsCrossRef::class)
        )
        var foods: List<FoodDao>
)