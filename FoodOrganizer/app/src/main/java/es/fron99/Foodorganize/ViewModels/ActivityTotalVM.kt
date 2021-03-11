package es.fron99.Foodorganize.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import es.fron99.Foodorganize.Dao.Model.*
import es.fron99.Foodorganize.Repository.Repository
import java.util.*

@Suppress("unused")
class ActivityTotalVM(application: Application) : AndroidViewModel(application) {

    /********************************************************FragmentSelected********************************************************/

    private var fragmentSelected: MutableLiveData<String> = MutableLiveData("FragmentCalendarMenus")

    fun getFragmentSelected() : LiveData<String>{
        return fragmentSelected
    }

    fun changeFragmentSelected(newValue: String) {
        this.fragmentSelected.value = newValue
    }

    /********************************************************ActivitySelected********************************************************/

    private var activitySelected: MutableLiveData<String> = MutableLiveData("Init")

    fun getActivitySelected() : LiveData<String>{
        return activitySelected
    }

    fun changeActivitySelected(newValue: String) {
        this.activitySelected.value = newValue
    }

    /********************************************************DaySelected********************************************************/

    private var daySelected: MutableLiveData<Calendar> = MutableLiveData(Calendar.getInstance())

    fun getDaySelected() : LiveData<Calendar> {
        return this.daySelected
    }

    fun changeDaySelected(date: Calendar) {
        this.daySelected.value = date
    }

    fun getValueDaySelected() : Calendar? {
        return this.daySelected.value
    }

    /********************************************************ObjSelected********************************************************/

    var timeMenuSelected: TimeMenuWithMenus = TimeMenuWithMenus()
    var menusSelected: MenuWithFoods = MenuWithFoods()
    var foodsSelected: FoodDao = FoodDao()

    /********************************************************Properties********************************************************/

    var menus: LiveData<List<MenuWithFoods>>
    var foods: LiveData<List<FoodDao>>
    fun timeMenus(): LiveData<List<TimeMenuWithMenus>> {
        return Transformations.switchMap( daySelected as LiveData<*>) {
            daySelected.value?.let { repository.getTimeMenusByDate(getApplication(), it) } }
    }

    private var repository : Repository = Repository()

    /********************************************************Init********************************************************/

    init {
        //TODO Cambiar a llamadas en hilos
        menus = repository.getMenus(application)
        foods = repository.getFoods(application)
    }

    /*************************************************************Food***********************************************************/

    fun insertFood(food: FoodDao){
        repository.insertFoods(getApplication(), food)
    }

    fun updateFood(food: FoodDao){
        repository.updateFoods(getApplication(), food)
    }

    fun dropFood(food: FoodDao){
        repository.deleteFoods(getApplication(), food)
    }

    /*************************************************************Menu***********************************************************/
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


    /*************************************************************TimeMenu***********************************************************/

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