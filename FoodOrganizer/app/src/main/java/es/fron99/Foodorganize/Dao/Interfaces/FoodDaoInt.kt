package es.fron99.Foodorganize.Dao.Interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.FoodDao

@Dao
interface FoodDaoInt{

    @Query("SELECT * FROM Foods")
    fun getFoods(): LiveData<List<FoodDao>>

    @Query("SELECT * FROM Foods WHERE idFood = :foodIds")
    fun getFoodsById(foodIds: IntArray?): LiveData<List<FoodDao>>

    @Insert
    fun insertFoods(vararg objects: FoodDao?)

    @Update
    fun updateFoods(vararg objects: FoodDao?)

    @Delete
    fun deleteFoods(vararg objects: FoodDao?)

}