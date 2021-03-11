package es.fron99.Foodorganize.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.Repository.Repository

@Suppress("unused")
class ActivityCreateVM(application: Application) : AndroidViewModel(application) {

    /********************************************************ObjSelected********************************************************/

    var foodSelected : FoodDao = FoodDao()
    var menuSelected : MenuWithFoods = MenuWithFoods()
    var timeMenuSelected : TimeMenuWithMenus = TimeMenuWithMenus()

    /********************************************************Properties********************************************************/

    var menus: LiveData<List<MenuWithFoods>>
    var foods: LiveData<List<FoodDao>>

    /********************************************************Init********************************************************/

    private var repository : Repository = Repository()

    init {
        //TODO Cambiar a llamadas en hilos
        menus = repository.getMenus(application)
        foods = repository.getFoods(application)
    }

}