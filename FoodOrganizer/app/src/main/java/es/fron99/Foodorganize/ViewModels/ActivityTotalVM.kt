package es.fron99.Foodorganize.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import es.fron99.Foodorganize.Dao.Model.*
import es.fron99.Foodorganize.Repository.Repository
import java.util.*

class ActivityTotalVM(application: Application) : AndroidViewModel(application) {

    /*********************************************************************************************************************/

    private lateinit var repository : Repository

    var fragmentSelected: MutableLiveData<String>?
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field!!
        }

    var activitySelected: MutableLiveData<String>?
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field!!
        }

    var daySelected: Calendar
        get() {
            return field.clone() as Calendar
        }

    lateinit var timeMenuSelected: TimeMenuWithMenus

    var timeMenus: LiveData<List<TimeMenuWithMenus>>?
        get() {
            if (field == null) {
                field = MutableLiveData(ArrayList())
            }
            return field!!
        }

    lateinit var menusSelected: MenuWithFoods

    var menus: LiveData<List<MenuWithFoods>>?
        get() {
            if (field == null) {
                field = MutableLiveData(ArrayList())
            }
            return field!!
        }

    lateinit var foodsSelected: FoodDao

    var foods: LiveData<List<FoodDao>>?
        get() {
            if (field == null) {
                field = MutableLiveData(ArrayList())
            }
            return field!!
        }

    fun changeFragmentSelected(newValue: String) {
        if (fragmentSelected == null) {
            fragmentSelected = MutableLiveData()
        }
        this.fragmentSelected?.value = newValue
    }


    init {
        fragmentSelected = MutableLiveData("FragmentCalendarMenus")
        activitySelected = MutableLiveData("Init")
        daySelected = Calendar.getInstance()
        repository = Repository()
        //TODO Cambiar a llamadas en hilos
        foods = repository.getFoods(application)
        menus = repository.getMenus(application)
        timeMenus = repository.getTimeMenusByDate(application, daySelected)
        foodsSelected = FoodDao()
        menusSelected = MenuWithFoods()
        timeMenuSelected = TimeMenuWithMenus()
    }

    /*********************************************************************************************************************/

    fun changeActivitySelected(newValue: String) {
        if (activitySelected == null) {
            activitySelected = MutableLiveData()
        }
        this.activitySelected?.value = newValue
    }

    /*************************************************************FOOD***********************************************************/

    fun insertFood(food : FoodDao){
        repository.insertFoods(getApplication(), food)
    }

    fun updateFood(food : FoodDao){
        repository.updateFoods(getApplication(), food)
    }

    fun dropFood(food : FoodDao){
        repository.deleteFoods(getApplication(), food)
    }

    /*************************************************************MENU***********************************************************/
/*
    fun insertMenu(menu : MenuWithFoods){
        repository.insertMenus(getApplication(), menu)
    }



    fun updateMenu(menu : MenuWithFoods){
        repository.updateMenus(getApplication(), menu)
    }

 */


    fun dropMenu(menu : MenuDao){
        repository.deleteMenus(getApplication(), menu)
    }


    /*************************************************************TIMEMENU***********************************************************/

    /*
    fun insertTimeMenu(timeMenu : TimeMenuWithMenus){
        repository.insertTimeMenus(getApplication(), timeMenu)
    }

    fun updateTimeMenu(timeMenu : TimeMenuWithMenus){
        repository.updateTimeMenus(getApplication(), timeMenu)
    }

     */

    fun dropTimeMenu(timeMenu : TimeMenuDao){
        repository.deleteTimeMenus(getApplication(), timeMenu)
    }

}