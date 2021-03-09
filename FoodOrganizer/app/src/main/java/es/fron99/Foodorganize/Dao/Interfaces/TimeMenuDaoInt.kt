package es.fron99.Foodorganize.Dao.Interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import es.fron99.Foodorganize.Dao.Model.*
import java.util.*

@Dao
interface TimeMenuDaoInt{

    @Transaction
    @Query("SELECT * FROM TimeMenus")
    fun getTimeMenus(): LiveData<List<TimeMenuWithMenus>>

    @Transaction
    @Query("SELECT * FROM TimeMenus WHERE Date = :date")
    fun getTimeMenusByDate(date: Date): LiveData<List<TimeMenuWithMenus>>

    /*
    @Transaction
    @Update
    fun updateTimeMenus(vararg objects: TimeMenuWithMenus?)

    @Transaction
    @Insert
    fun insertTimeMenus(vararg objects: TimeMenuWithMenus?)
    */

    @Transaction
    @Delete
    fun deleteTimeMenus(vararg objects: TimeMenuDao?)   //TODO NO ESTA BIEN, SOLO BORRA EL TIME MENU PERO NO LAS RELACCIONES DE LA TABLA NM

}