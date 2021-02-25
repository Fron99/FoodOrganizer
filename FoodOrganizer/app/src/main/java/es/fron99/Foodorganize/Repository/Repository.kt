package es.fron99.Foodorganize.Repository

import android.content.Context
import es.fron99.Foodorganize.Dao.DatabaseFoodOrganize
import es.fron99.Foodorganize.Models.Food

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

}