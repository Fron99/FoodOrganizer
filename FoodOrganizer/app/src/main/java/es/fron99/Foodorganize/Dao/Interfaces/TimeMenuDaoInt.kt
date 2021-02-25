package es.fron99.Foodorganize.Dao.Interfaces

import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuDao
import es.fron99.Foodorganize.Dao.Model.TimeMenuDao

@Dao
interface TimeMenuDaoInt {

 @Query("SELECT id, Name FROM TimeMenus")
 fun getTimeMenus(): List<TimeMenuDao>

 /*
 @Query("SELECT id, Name FROM TimeMenus WHERE id IN (:timeMenusIds)")
 fun getTimeMenusById(timeMenusIds: IntArray?): ArrayList<TimeMenuDao?>?
 */

 /*
 @Query("SELECT M.id, M.Name, M.SmallDescription FROM TimeMenus_Menus AS TMM INNER JOIN Menus AS M ON M.id = TMM.idMenu WHERE TMM.idTimeMenu IN (:menusIds)")
 fun getMenusOfTimeMenu(menusIds: IntArray?): List<MenuDao>
*/
 @Query("SELECT M.id, M.Name, M.SmallDescription FROM TimeMenus_Menus AS TMM INNER JOIN Menus AS M ON M.id = TMM.idMenu WHERE TMM.idTimeMenu = :menusIds")
 fun getMenusOfTimeMenu(menusIds: Int): List<MenuDao>

 @Update
 fun updateTimeMenus(vararg timeMenus: TimeMenuDao?)

 @Insert
 fun insertTimeMenus(vararg timeMenus: TimeMenuDao?)

 @Delete
 fun deleteTimeMenus(timeMenus: TimeMenuDao?)


}