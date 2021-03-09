package es.fron99.Foodorganize.Dao.Interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods

@Dao
interface MenuDaoInt{

    @Transaction
    @Query("SELECT * FROM Menus")
    fun getMenus(): LiveData<List<MenuWithFoods>>

    @Transaction
    @Query("SELECT * FROM Menus WHERE idMenu = :menusIds")
    fun getMenuById(menusIds: IntArray?): LiveData<List<MenuWithFoods>>

    /*
    @Transaction
    @Insert
    fun insertMenus(vararg objects: MenuWithFoods?)

    @Transaction
    @Update
    fun updateMenus(vararg objects: MenuWithFoods?)
    */

    @Transaction
    @Delete
    fun deleteMenus(vararg objects: MenuDao?)

}