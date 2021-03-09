package es.fron99.Foodorganize.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import es.fron99.Foodorganize.Dao.DatabaseFoodOrganize
import es.fron99.Foodorganize.Dao.Model.*
import java.util.*
import kotlin.collections.ArrayList

class Repository {

    /************************************************FOOD************************************************/

    fun getFoods(context : Context) : LiveData<List<FoodDao>> {
        return DatabaseFoodOrganize.getDatabase(context).foodDao().getFoods()
    }

    fun getFoodsById(context : Context, foodIds: IntArray?) : LiveData<List<FoodDao>> {
        return DatabaseFoodOrganize.getDatabase(context).foodDao().getFoodsById(foodIds)
    }

    fun insertFoods(context : Context, vararg objects: FoodDao?){
        DatabaseFoodOrganize.getDatabase(context).foodDao().insertFoods(*objects)
    }

    fun updateFoods(context : Context, vararg objects: FoodDao?){
        DatabaseFoodOrganize.getDatabase(context).foodDao().updateFoods(*objects)
    }

    fun deleteFoods(context : Context, vararg objects: FoodDao?){
        DatabaseFoodOrganize.getDatabase(context).foodDao().deleteFoods(*objects)
    }

    /************************************************MENU************************************************/

    fun getMenus(context : Context) : LiveData<List<MenuWithFoods>> {
        return DatabaseFoodOrganize.getDatabase(context).menuDao().getMenus()
    }

    fun getMenusById(context : Context, menusIds: IntArray?) : LiveData<List<MenuWithFoods>> {
        return DatabaseFoodOrganize.getDatabase(context).menuDao().getMenuById(menusIds)
    }

    /*
    fun insertMenus(context : Context, vararg objects: MenuWithFoods?){
        DatabaseFoodOrganize.getDatabase(context).menuDao().insertMenus(*objects)
    }

    fun updateMenus(context : Context, vararg objects: MenuWithFoods?){
        DatabaseFoodOrganize.getDatabase(context).menuDao().updateMenus(*objects)
    }
    */

    fun deleteMenus(context : Context, vararg objects: MenuDao?){
        DatabaseFoodOrganize.getDatabase(context).menuDao().deleteMenus(*objects)
    }

    /************************************************TIMEMENU************************************************/

    fun getTimeMenus(context : Context) : LiveData<List<TimeMenuWithMenus>> {
        return DatabaseFoodOrganize.getDatabase(context).timeMenuDao().getTimeMenus()
    }

    fun getTimeMenusByDate(context: Context, date : Calendar) : LiveData<List<TimeMenuWithMenus>> {
        return DatabaseFoodOrganize.getDatabase(context).timeMenuDao().getTimeMenusByDate(Date(date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH)))
    }
/*
    fun insertTimeMenus(context : Context, vararg objects: TimeMenuWithMenus?){
        DatabaseFoodOrganize.getDatabase(context).timeMenuDao().insertTimeMenus(*objects)
    }

    fun updateTimeMenus(context : Context, vararg objects: TimeMenuWithMenus?){
        DatabaseFoodOrganize.getDatabase(context).timeMenuDao().updateTimeMenus(*objects)
    }
    */

    fun deleteTimeMenus(context : Context, vararg objects: TimeMenuDao?){
        DatabaseFoodOrganize.getDatabase(context).timeMenuDao().deleteTimeMenus(*objects)
    }

}