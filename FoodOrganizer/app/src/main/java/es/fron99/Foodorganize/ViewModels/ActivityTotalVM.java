package es.fron99.Foodorganize.ViewModels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import es.fron99.Foodorganize.Dao.Model.FoodDao;
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods;
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus;
import es.fron99.Foodorganize.Models.Food;
import es.fron99.Foodorganize.Models.Menu;
import es.fron99.Foodorganize.Models.TimeMenu;
import es.fron99.Foodorganize.Repository.Repository;


public class ActivityTotalVM extends AndroidViewModel {

    private MutableLiveData<String> fragmentSelected;
    private LiveData<List<TimeMenuWithMenus>> timeMenu;
    private LiveData<List<MenuWithFoods>> menus;
    private LiveData<List<FoodDao>> foods;
    private Calendar daySelected;

    public ActivityTotalVM(@NonNull Application application) {
        super(application);
        daySelected = Calendar.getInstance();
        this.fragmentSelected = new MutableLiveData<>("FragmentCalendarMenus");
        /*
        this.foods = new MutableLiveData<>(new ArrayList<>());
        this.menus = new MutableLiveData<>(new ArrayList<>());
        this.timeMenu = new MutableLiveData<>(new ArrayList<>());
        */


        Repository repository = new Repository();
        this.foods = repository.getFoods(application);
        this.menus = repository.getMenus(application);
        this.timeMenu = repository.getTimeMenusByDate(application, daySelected);
    }


    public LiveData<String> getFragmentSelected(){
        if (fragmentSelected == null){
            fragmentSelected = new MutableLiveData<>();
        }
        return fragmentSelected;
    }

    public void changeFragmentSelected(String newValue){
        if (fragmentSelected == null){
            fragmentSelected = new MutableLiveData<>();
        }
        fragmentSelected.setValue(newValue);
    }

    public LiveData<List<FoodDao>> getFoods(){
        if (foods == null){
            foods = new MutableLiveData<>();
        }
        return foods;
    }

    public LiveData<List<MenuWithFoods>> getMenus(){
        if (menus == null){
            menus = new MutableLiveData<>(new ArrayList<>());
        }
        return menus;
    }

    public LiveData<List<TimeMenuWithMenus>> getTimeMenus(){
        if (timeMenu == null){
            timeMenu = new MutableLiveData<>(new ArrayList<>());
        }
        return timeMenu;
    }

    public Calendar getDaySelected(){
        return (Calendar) daySelected.clone();
    }

    public void setDaySelected(Calendar calendar){
        daySelected = calendar;
    }

}