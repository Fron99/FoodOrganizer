package es.fron99.Foodorganize.Dao.Interfaces

import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.TimeMenuDao

@Dao
interface TimeMenuDaoInt {

    @Query("SELECT id, Name FROM TimeMenus")
    fun getMenus(): List<TimeMenuDao?>?

    @Query("SELECT id, Name FROM TimeMenus WHERE id IN (:timeMenusIds)")
    fun getMenusById(timeMenusIds: IntArray?): List<TimeMenuDao?>?

    @Update
    fun updateMenus(vararg timeMenus: TimeMenuDao?)

    @Insert
    fun insertMenus(vararg timeMenus: TimeMenuDao?)

    @Delete
    fun deleteMenus(timeMenus: TimeMenuDao?)


}