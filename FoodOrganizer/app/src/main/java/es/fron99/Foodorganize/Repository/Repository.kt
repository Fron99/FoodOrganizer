package es.fron99.Foodorganize.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import es.fron99.Foodorganize.Dao.DatabaseFoodOrganize
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods

class Repository {

    fun getFoods(context : Context) : LiveData<List<FoodDao>> {
        return DatabaseFoodOrganize.getDatabase(context).foodDao().getFoods()
    }


    fun getFoodsById(context : Context, foodIds: IntArray?) : LiveData<List<FoodDao>> {
        return DatabaseFoodOrganize.getDatabase(context).foodDao().getFoodsById(foodIds)
    }

    fun getMenus(context : Context) : LiveData<List<MenuWithFoods>> {
        return DatabaseFoodOrganize.getDatabase(context).menuDao().getMenus()
    }


    fun getMenusById(context : Context, menusIds: IntArray?) : LiveData<List<MenuWithFoods>> {
        return DatabaseFoodOrganize.getDatabase(context).menuDao().getMenuById(menusIds)
    }


    /*


    fun getFoodsOfMenu(context : Context, idMenu: Int) : ArrayList<Food>{
        return UtilRepository.parseListFoodDaoToArrayListFood(DatabaseFoodOrganize.getDatabase(context).foodDao().getFoodsOfMenu(idMenu))
    }


    fun getMenus(context : Context) : ArrayList<Menu>{

        val menus = UtilRepository.parseListMenuDaoToArrayListMenu(DatabaseFoodOrganize.getDatabase(context).menuDao().getMenus())
        var listFoods : ArrayList<Food>

        for (menu in menus){

            listFoods = getFoodsOfMenu(context, menu.id)
            menu.foods = listFoods

        }

        return menus
    }


    fun getMenuById(context : Context, menuId: Int) : Menu{

        val menu = UtilRepository.parseMenuDaoToMenu(DatabaseFoodOrganize.getDatabase(context).menuDao().getMenuById(menuId))
        menu.foods = getFoodsOfMenu(context, menu.id)
        return menu
    }


    fun getMenusOfTimeMenu(context : Context, menusIds: Int) : ArrayList<Menu>{

        val menus = UtilRepository.parseListMenuDaoToArrayListMenu(DatabaseFoodOrganize.getDatabase(context).menuDao().getMenusOfTimeMenu(menusIds))

        var listFoods : ArrayList<Food>

        for (menu in menus){

            listFoods = getFoodsOfMenu(context, menu.id)
            menu.foods = listFoods

        }

        return menus
    }


    fun getTimeMenus(context: Context) : ArrayList<TimeMenu> {

        val listTimeMenu = UtilRepository.parseListTimeMenuDaoToArrayListTimeMenu(DatabaseFoodOrganize.getDatabase(context).timeMenuDao().getTimeMenus())
        var listMenus : ArrayList<Menu>

        for (timeMenu in listTimeMenu) {
            listMenus = getMenusOfTimeMenu(context, timeMenu.id)
            timeMenu.menus = listMenus
        }

        return listTimeMenu
    }


    fun getTimeMenusByDate(context: Context, date : Calendar) : ArrayList<TimeMenu> {

        var getDateOnly : Date = Date(date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH))

        val listTimeMenu = UtilRepository.parseListTimeMenuDaoToArrayListTimeMenu(DatabaseFoodOrganize.getDatabase(context).timeMenuDao().getTimeMenusByDate(getDateOnly))
        var listMenus : ArrayList<Menu>

        for (timeMenu in listTimeMenu) {

            listMenus = getMenusOfTimeMenu(context, timeMenu.id)
            timeMenu.menus = listMenus

        }

        return listTimeMenu
    }


     */

}