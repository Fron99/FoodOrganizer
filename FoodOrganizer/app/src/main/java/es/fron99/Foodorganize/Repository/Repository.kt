package es.fron99.Foodorganize.Repository

import android.content.Context
import es.fron99.Foodorganize.Dao.DatabaseFoodOrganize
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuDao
import es.fron99.Foodorganize.Models.Food
import es.fron99.Foodorganize.Models.Menu
import es.fron99.Foodorganize.Models.TimeMenu

class Repository {

    fun getFoods(context : Context) : ArrayList<Food>{
        return UtilRepository.parseListFoodDaoToArrayListFood(DatabaseFoodOrganize.getDatabase(context).foodDao().getFoods())
    }

    fun getFoodsById(context : Context, foodIds: Int) : ArrayList<Food>{
        return UtilRepository.parseListFoodDaoToArrayListFood(DatabaseFoodOrganize.getDatabase(context).foodDao().getFoodsById(foodIds))
    }

    fun getFoodsOfMenu(context : Context, foodIds: Int) : ArrayList<Food>{
        return UtilRepository.parseListFoodDaoToArrayListFood(DatabaseFoodOrganize.getDatabase(context).menuDao().getFoodsOfMenu(foodIds))
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


    fun getMenusById(context : Context, menusIds: Int) : ArrayList<Menu>{

        val menus = UtilRepository.parseListMenuDaoToArrayListMenu(DatabaseFoodOrganize.getDatabase(context).menuDao().getMenusById(menusIds))

        var listFoods : ArrayList<Food>

        for (menu in menus){

            listFoods = getFoodsOfMenu(context, menu.id)
            menu.foods = listFoods

        }

        return menus
    }

    fun getMenusOfTimeMenu(context : Context, menusIds: Int) : ArrayList<Menu>{

        val menus = UtilRepository.parseListMenuDaoToArrayListMenu(DatabaseFoodOrganize.getDatabase(context).timeMenuDao().getMenusOfTimeMenu(menusIds))

        var listFoods : ArrayList<Food>

        for (menu in menus){

            listFoods = getFoodsOfMenu(context, menu.id)
            menu.foods = listFoods

        }

        return menus
    }


    //TODO Hay que crear un metodo que te devuelva solo menus de un dia
    fun getTimeMenus(context: Context) : ArrayList<TimeMenu> {

        val listTimeMenu = UtilRepository.parseListTimeMenuDaoToArrayListTimeMenu(DatabaseFoodOrganize.getDatabase(context).timeMenuDao().getTimeMenus())
        var listMenus : ArrayList<Menu>

        for (timeMenu in listTimeMenu) {

            listMenus = getMenusOfTimeMenu(context, timeMenu.id)
            timeMenu.menus = listMenus

        }

        return listTimeMenu
    }

}