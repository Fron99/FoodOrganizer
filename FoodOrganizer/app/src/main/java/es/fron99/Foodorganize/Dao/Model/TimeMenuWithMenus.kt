package es.fron99.Foodorganize.Dao.Model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TimeMenuWithMenus(
        @Embedded var timeMenu: TimeMenuDao,
        @Relation(
                parentColumn = "idTimeMenu",
                entityColumn = "idMenu",
                associateBy = Junction(TimeMenusMenusCrossRef::class)
        )
        //TODO Cambiar MenuDao por MenuWithFoods
        var menus: List<MenuDao>
)