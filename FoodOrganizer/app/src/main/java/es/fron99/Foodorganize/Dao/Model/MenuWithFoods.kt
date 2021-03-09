package es.fron99.Foodorganize.Dao.Model

import androidx.room.*


data class MenuWithFoods(
        @Embedded var menu: MenuDao,
        @Relation(
                parentColumn = "idMenu",
                entityColumn = "idFood",
                associateBy = Junction(MenusFoodsCrossRef::class)
        )
        var foods: List<FoodDao>

){
        @Ignore
        var timeToPrepare : Int = 0
                get() {
                        field = 0;
                        for (i in foods.indices){
                                field += foods[i].timeToPrepare
                        }
                        return field
                }
}