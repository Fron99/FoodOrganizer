package es.fron99.Foodorganize.Dao.Interfaces

import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuDao
import es.fron99.Foodorganize.Models.Food

@Dao
interface MenuDaoInt {

    @Query("SELECT id, Name, SmallDescription FROM Menus")
    fun getMenus(): List<MenuDao>

    @Query("SELECT id, Name, SmallDescription FROM Menus WHERE id = :menusIds")
    fun getMenusById(menusIds: Int): List<MenuDao>

    @Query("SELECT F.id, F.Name, F.SmallDescription, F.TimeToPrepare FROM  Menus_Foods AS MF INNER JOIN Foods AS F ON F.id = MF.idFood WHERE MF.idMenu = :menusIds")
    fun getFoodsOfMenu(menusIds: Int): List<FoodDao>

    @Update
    fun updateMenus(vararg menus: MenuDao?)

    @Insert
    fun insertMenus(vararg menus: MenuDao?)

    @Delete
    fun deleteMenus(menus: MenuDao?)

}