package es.fron99.Foodorganize.Repository

import es.fron99.Foodorganize.Dao.Model.*
import es.fron99.Foodorganize.Models.Food
import es.fron99.Foodorganize.Models.Menu
import es.fron99.Foodorganize.Models.TimeMenu
import java.util.*
import kotlin.collections.ArrayList

class UtilRepository {

    companion object{

        /************************************************FOOD************************************************/

        fun parseFoodDaoToFood(foodToParse : FoodDao) : Food{
            return Food(foodToParse.idFood, foodToParse.name, foodToParse.smallDescription, foodToParse.timeToPrepare)
        }

        fun parseListFoodDaoToArrayListFood(foodToParse : List<FoodDao>) : ArrayList<Food>{

            val listFoodParsed : ArrayList<Food> = ArrayList()

            for (item in foodToParse){
                listFoodParsed.add(parseFoodDaoToFood(item))
            }

            return listFoodParsed
        }

        /************************************************MENU************************************************/

        fun parseMenuDaoToMenu(menuToParse : MenuDao) : Menu {
            return Menu(menuToParse.idMenu, menuToParse.name, menuToParse.smallDescription, ArrayList())
        }

        fun parseMenuWithFoodsToMenu(menuToParse : MenuWithFoods) : Menu {
            return Menu(parseMenuDaoToMenu(menuToParse.menu),parseListFoodDaoToArrayListFood(menuToParse.foods))
        }

        fun parseListMenuWithFoodsToArrayListMenu(menuToParse : List<MenuWithFoods>) : ArrayList<Menu> {

            val listMenuParsed : ArrayList<Menu> = ArrayList()

            for (item in menuToParse){
                listMenuParsed.add(parseMenuWithFoodsToMenu(item))
            }

            return listMenuParsed
        }

        fun parseListMenuDaoToArrayListMenu(menuToParse : List<MenuDao>) : ArrayList<Menu> {

            val listMenuParsed : ArrayList<Menu> = ArrayList()

            for (item in menuToParse){
                listMenuParsed.add(parseMenuDaoToMenu(item))
            }

            return listMenuParsed
        }

        /************************************************TIMEMENU************************************************/

        fun parseTimeMenuDaoToTimeMenu(timeMenuToParse : TimeMenuDao) : TimeMenu {
            return TimeMenu(timeMenuToParse.idTimeMenu, timeMenuToParse.name, ArrayList(), timeMenuToParse.date)
        }

        fun parseTimeMenuWithMenusToTimeMenu(timeMenuWithMenus : TimeMenuWithMenus) : TimeMenu {
            //return TimeMenu(parseTimeMenuDaoToTimeMenu(timeMenuWithMenus.timeMenu), parseListMenuWithFoodsToArrayListMenu(timeMenuWithMenus.menus))
            return TimeMenu(parseTimeMenuDaoToTimeMenu(timeMenuWithMenus.timeMenu), parseListMenuDaoToArrayListMenu(timeMenuWithMenus.menus))
        }

        fun parseListTimeMenuWithMenusToArrayListTimeMenu(timeMenuToParse : List<TimeMenuWithMenus>) : ArrayList<TimeMenu> {

            val listMenuParsed : ArrayList<TimeMenu> = ArrayList()

            for (item in timeMenuToParse){
                listMenuParsed.add(parseTimeMenuWithMenusToTimeMenu(item))
            }

            return listMenuParsed
        }

    }

}