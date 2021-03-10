package es.fron99.Foodorganize.ViewModels

import android.app.Application
import androidx.arch.core.util.Function
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import es.fron99.Foodorganize.Dao.Model.*
import es.fron99.Foodorganize.Repository.Repository
import java.util.*


class ActivityTotalVM(application: Application) : AndroidViewModel(application) {

    /*********************************************************************************************************************/

    private var repository : Repository

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

    private var daySelected: MutableLiveData<Calendar>?


    var timeMenuSelected: TimeMenuWithMenus

    /*
    var timeMenus: LiveData<List<TimeMenuWithMenus>>?
        get() {
            if (field == null) {
                field = MutableLiveData(ArrayList())
            }
            return field!!
        }


     */
    var menusSelected: MenuWithFoods

    var menus: LiveData<List<MenuWithFoods>>?
        get() {
            if (field == null) {
                field = MutableLiveData(ArrayList())
            }
            return field!!
        }

    var foodsSelected: FoodDao

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

    fun changeDaySelected(date: Calendar) {
        if (daySelected == null) {
            daySelected = MutableLiveData(Calendar.getInstance())
        }
        this.daySelected?.value = date
    }

    fun getDaySelected() : Calendar? {
        if (daySelected == null) {
            daySelected = MutableLiveData(Calendar.getInstance())
        }
        return this.daySelected?.value
    }


    init {
        fragmentSelected = MutableLiveData("FragmentCalendarMenus")
        activitySelected = MutableLiveData("Init")
        daySelected = MutableLiveData(Calendar.getInstance())
        repository = Repository()
        //TODO Cambiar a llamadas en hilos
        foods = repository.getFoods(application)
        menus = repository.getMenus(application)
        foodsSelected = FoodDao()
        menusSelected = MenuWithFoods()
        timeMenuSelected = TimeMenuWithMenus()
    }

    fun timeMenus(): LiveData<List<TimeMenuWithMenus>> {
        return Transformations.switchMap( daySelected as LiveData<*>) {
        daySelected?.value?.let { repository.getTimeMenusByDate(getApplication(), it) } }
    }

    /*********************************************************************************************************************/

    fun changeActivitySelected(newValue: String) {
        if (activitySelected == null) {
            activitySelected = MutableLiveData()
        }
        this.activitySelected?.value = newValue
    }

    /*************************************************************FOOD***********************************************************/

    fun insertFood(food: FoodDao){
        repository.insertFoods(getApplication(), food)
    }

    fun updateFood(food: FoodDao){
        repository.updateFoods(getApplication(), food)
    }

    fun dropFood(food: FoodDao){
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


    fun dropMenu(menu: MenuDao){
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

    fun dropTimeMenu(timeMenu: TimeMenuDao){
        repository.deleteTimeMenus(getApplication(), timeMenu)
    }

}