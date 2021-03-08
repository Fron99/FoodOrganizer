package es.fron99.Foodorganize.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.Repository.Repository
import java.util.*


class ActivityTotalVM(application: Application) : AndroidViewModel(application) {

    private var fragmentSelected: MutableLiveData<String>?
    private var daySelected: Calendar
    private var timeMenu: LiveData<List<TimeMenuWithMenus>>?
    private var menus: LiveData<List<MenuWithFoods>>?
    private var foods: LiveData<List<FoodDao>>?


    init {
        fragmentSelected = MutableLiveData("FragmentCalendarMenus")
        daySelected = Calendar.getInstance()
        val repository = Repository()
        //TODO Cambiar a llamadas en hilos
        foods = repository.getFoods(application)
        menus = repository.getMenus(application)
        timeMenu = repository.getTimeMenusByDate(application, daySelected)
    }

    fun getFragmentSelected(): LiveData<String> {
        if (fragmentSelected == null) {
            fragmentSelected = MutableLiveData()
        }
        return this.fragmentSelected!!
    }

    fun changeFragmentSelected(newValue: String) {
        if (fragmentSelected == null) {
            fragmentSelected = MutableLiveData()
        }
        this.fragmentSelected?.value = newValue
    }

    fun getFoods(): LiveData<List<FoodDao>> {
        if (foods == null) {
            foods = MutableLiveData()
        }
        return this.foods!!
    }

    fun getMenus(): LiveData<List<MenuWithFoods>> {
        if (menus == null) {
            menus = MutableLiveData(ArrayList())
        }
        return this.menus!!
    }

    val timeMenus: LiveData<List<TimeMenuWithMenus>>
        get() {
            if (timeMenu == null) {
                timeMenu = MutableLiveData(ArrayList())
            }
            return this.timeMenu!!
        }

    fun getDaySelected(): Calendar {
        return daySelected.clone() as Calendar
    }

    fun setDaySelected(calendar: Calendar) {
        daySelected = calendar
    }

}