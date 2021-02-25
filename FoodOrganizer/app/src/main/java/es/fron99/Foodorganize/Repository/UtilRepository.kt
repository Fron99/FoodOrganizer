package es.fron99.Foodorganize.Repository

import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuDao
import es.fron99.Foodorganize.Dao.Model.TimeMenuDao
import es.fron99.Foodorganize.Models.Food
import es.fron99.Foodorganize.Models.Menu
import es.fron99.Foodorganize.Models.TimeMenu

class UtilRepository {

    companion object{

        fun parseFoodDaoToFood(foodToParse : FoodDao) : Food{
            return Food(foodToParse.id, foodToParse.name, foodToParse.smallDescription, foodToParse.timeToPrepare)
        }

        fun parseMenuDaoToMenu(menuToParse : MenuDao) : Menu {
            return Menu(menuToParse.id, menuToParse.name, menuToParse.smallDescription, ArrayList())
        }

        fun parseTimeMenuDaoToTimeMenu(timeMenuToParse : TimeMenuDao) : TimeMenu {
            return TimeMenu(timeMenuToParse.id, timeMenuToParse.name, ArrayList())
        }

        fun parseListFoodDaoToArrayListFood(foodToParse : List<FoodDao>) : ArrayList<Food>{

            val listFoodParsed : ArrayList<Food> = ArrayList()

            for (item in foodToParse){
                listFoodParsed.add(parseFoodDaoToFood(item))
            }

            return listFoodParsed
        }

        fun parseListMenuDaoToArrayListMenu(menuToParse : List<MenuDao>) : ArrayList<Menu> {

            val listMenuParsed : ArrayList<Menu> = ArrayList()

            for (item in menuToParse){
                listMenuParsed.add(parseMenuDaoToMenu(item))
            }

            return listMenuParsed
        }

        fun parseListTimeMenuDaoToArrayListTimeMenu(timeMenuToParse : List<TimeMenuDao>) : ArrayList<TimeMenu> {

            val listMenuParsed : ArrayList<TimeMenu> = ArrayList()

            for (item in timeMenuToParse){
                listMenuParsed.add(parseTimeMenuDaoToTimeMenu(item))
            }

            return listMenuParsed
        }

    }

}