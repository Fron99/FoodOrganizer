package es.fron99.Foodorganize.Dao.Interfaces

import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.MenuDao

@Dao
interface MenuDaoInt {

    @Query("SELECT id, Name, SmallDescription FROM Menus")
    fun getMenus(): List<MenuDao?>?

    @Query("SELECT id, Name, SmallDescription FROM Menus WHERE id IN (:menusIds)")
    fun getMenusById(menusIds: IntArray?): List<MenuDao?>?

    @Update
    fun updateMenus(vararg menus: MenuDao?)

    @Insert
    fun insertMenus(vararg menus: MenuDao?)

    @Delete
    fun deleteMenus(menus: MenuDao?)

}