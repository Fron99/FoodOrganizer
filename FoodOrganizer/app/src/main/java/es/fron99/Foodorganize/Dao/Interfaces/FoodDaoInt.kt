package es.fron99.Foodorganize.Dao.Interfaces

import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.FoodDao

@Dao
interface FoodDaoInt {

    @Query("SELECT id, Name, SmallDescription, TimeToPrepare FROM Foods")
    fun getFoods(): List<FoodDao>

    @Query("SELECT id, Name, SmallDescription, TimeToPrepare FROM Foods WHERE id = :foodIds")
    fun getFoodsById(foodIds: Int): List<FoodDao>

    @Query("SELECT F.id, F.Name, F.SmallDescription, F.TimeToPrepare FROM  Menus_Foods AS MF INNER JOIN Foods AS F ON F.id = MF.idFood WHERE MF.idMenu = :menusIds")
    fun getFoodsOfMenu(menusIds: Int): List<FoodDao>

    @Update
    fun updateFood(vararg foods: FoodDao?)

    @Insert
    fun insertFood(vararg foods: FoodDao?)

    @Delete
    fun deleteFood(food: FoodDao?)


}