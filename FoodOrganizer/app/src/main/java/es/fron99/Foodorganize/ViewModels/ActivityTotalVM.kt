package es.fron99.Foodorganize.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.Repository.Repository
import java.util.*


class ActivityTotalVM(application: Application) : AndroidViewModel(application) {

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

    var timeMenus: LiveData<List<TimeMenuWithMenus>>?
        get() {
            if (field == null) {
                field = MutableLiveData(ArrayList())
            }
            return field!!
        }

    var menus: LiveData<List<MenuWithFoods>>?
        get() {
            if (field == null) {
                field = MutableLiveData(ArrayList())
            }
            return field!!
        }

    var foods: LiveData<List<FoodDao>>?
        get() {
            if (field == null) {
                field = MutableLiveData(ArrayList())
            }
            return field!!
        }


    init {
        fragmentSelected = MutableLiveData("FragmentCalendarMenus")
        activitySelected = MutableLiveData("Init")
        daySelected = Calendar.getInstance()
        val repository = Repository()
        //TODO Cambiar a llamadas en hilos
        foods = repository.getFoods(application)
        menus = repository.getMenus(application)
        timeMenus = repository.getTimeMenus(application)
    }

    fun changeFragmentSelected(newValue: String) {
        if (fragmentSelected == null) {
            fragmentSelected = MutableLiveData()
        }
        this.fragmentSelected?.value = newValue
    }

    fun changeActivitySelected(newValue: String) {
        if (activitySelected == null) {
            activitySelected = MutableLiveData()
        }
        this.activitySelected?.value = newValue
    }

}