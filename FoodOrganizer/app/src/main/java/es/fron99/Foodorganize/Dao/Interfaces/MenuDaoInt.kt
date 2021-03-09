package es.fron99.Foodorganize.Dao.Interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods

@Dao
interface MenuDaoInt{

    @Transaction
    @Query("SELECT * FROM Menus")
    fun getMenus(): LiveData<List<MenuWithFoods>>

    @Transaction
    @Query("SELECT * FROM Menus WHERE idMenu = :menusIds")
    fun getMenuById(menusIds: IntArray?): LiveData<List<MenuWithFoods>>

}