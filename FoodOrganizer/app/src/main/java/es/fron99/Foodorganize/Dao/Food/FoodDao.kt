package es.fron99.Foodorganize.Dao.Food

import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.Food

@Dao
interface FoodDao {

    @Query("SELECT id, Name, SmallDescription, TimeToPrepare FROM Foods")
    fun getFoods(): List<Food?>?

    @Query("SELECT id, Name, SmallDescription, TimeToPrepare FROM Foods WHERE id IN (:foodIds)")
    fun getFoodsById(foodIds: IntArray?): List<Food?>?

    @Update
    fun updateFood(vararg foods: Food?)

    @Insert
    fun insertFood(vararg foods: Food?)

    @Delete
    fun deleteFood(food: Food?)


}