package es.fron99.Foodorganize.Repository

import android.content.Context
import es.fron99.Foodorganize.Dao.DatabaseFoodOrganize
import es.fron99.Foodorganize.Models.Food
import es.fron99.Foodorganize.Models.Menu

class Repository {

    fun getFoods(context : Context) : ArrayList<Food>{

        val foodDao = DatabaseFoodOrganize.getDatabase(context).foodDao().getFoods()
        val listFood : ArrayList<Food> = ArrayList()

        if (foodDao != null){
            for (item in foodDao){
                if (item != null) {
                    listFood.add(Food(item.id,item.name,item.smallDescription,item.timeToPrepare))
                }
            }
        }

        return listFood
    }

    fun getMenus(context : Context) : ArrayList<Menu>{

        //TODO Hay que hacer un metodo que devuelva
        val menuDao = DatabaseFoodOrganize.getDatabase(context).menuDao().getMenus()
        val listMenu : ArrayList<Menu> = ArrayList()
        var listIdFood : ArrayList<Int>

        if (menuDao != null){
            for (item in menuDao){
                if (item != null) {

                    //listIdFood = DatabaseFoodOrganize.getDatabase(context).menu_FoodDao().getFoodsByIdMenu(ArrayList(item.id))

                    listMenu.add(Menu(item.id,item.name,item.smallDescription,ArrayList()))
                }
            }
        }

        return listMenu
    }

}