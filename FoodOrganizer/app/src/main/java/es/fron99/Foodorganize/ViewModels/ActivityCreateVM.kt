package es.fron99.Foodorganize.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.Repository.Repository
import java.util.*


class ActivityCreateVM(application: Application) : AndroidViewModel(application) {

    var foodSelected : FoodDao = FoodDao()
    var menuSelected : MenuWithFoods = MenuWithFoods()
    var timeMenuSelected : TimeMenuWithMenus = TimeMenuWithMenus()

}