package es.fron99.foodorganize.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import es.fron99.foodorganize.Models.Food;
import es.fron99.foodorganize.Models.Menu;
import es.fron99.foodorganize.Models.TimeMenu;

public class ActivityTotalVM extends ViewModel {

    private MutableLiveData<String> fragmentSelected;
    private MutableLiveData<ArrayList<TimeMenu>> timeMenu;
    private MutableLiveData<ArrayList<Menu>> menus;
    private MutableLiveData<ArrayList<Food>> foods;
    private Calendar daySelected;

    public ActivityTotalVM(){
        this.fragmentSelected = new MutableLiveData<>();
        this.timeMenu = new MutableLiveData<>(new ArrayList<>());
        this.menus = new MutableLiveData<>(new ArrayList<>());
        this.foods = new MutableLiveData<>(new ArrayList<>());
        daySelected = Calendar.getInstance();
    }

    public LiveData<String> getFragmentSelected(){
        if (fragmentSelected == null){
            fragmentSelected = new MutableLiveData<>();
        }
        return fragmentSelected;
    }

    public String getValueFragmentSelected(){
        if (fragmentSelected == null){
            fragmentSelected = new MutableLiveData<>();
        }
        return fragmentSelected.getValue();
    }

    public void changeFragmentSelected(String newValue){
        if (fragmentSelected == null){
            fragmentSelected = new MutableLiveData<>();
        }
        fragmentSelected.setValue(newValue);
    }

    public LiveData<ArrayList<TimeMenu>> getTimeMenus(){
        if (timeMenu == null){
            timeMenu = new MutableLiveData<>(new ArrayList<>());
        }
        return timeMenu;
    }

    public void addTimeMenu(TimeMenu newValue){
        if (timeMenu == null){
            timeMenu = new MutableLiveData<>(new ArrayList<>());
        }
        ArrayList<TimeMenu> totalTimeMenu = timeMenu.getValue();
        assert totalTimeMenu != null;
        totalTimeMenu.add(newValue);
        timeMenu.setValue(totalTimeMenu);
    }

    public void removeTimeMenu(TimeMenu newValue){
        if (timeMenu == null){
            timeMenu = new MutableLiveData<>(new ArrayList<>());
        }
        ArrayList<TimeMenu> totalTimeMenu = timeMenu.getValue();
        assert totalTimeMenu != null;
        totalTimeMenu.remove(newValue);
        timeMenu.setValue(totalTimeMenu);
    }

    public TimeMenu getTimeMenu(int i){
        if (timeMenu == null){
            timeMenu = new MutableLiveData<>(new ArrayList<>());
        }
        return timeMenu.getValue().get(i);
    }

    public LiveData<ArrayList<Menu>> getMenus(){
        if (menus == null){
            menus = new MutableLiveData<>(new ArrayList<>());
        }
        return menus;
    }

    public void addMenu(Menu newValue){
        if (menus == null){
            menus = new MutableLiveData<>(new ArrayList<>());
        }
        ArrayList<Menu> totalMenus = menus.getValue();
        assert totalMenus != null;
        totalMenus.add(newValue);
        menus.setValue(totalMenus);
    }

    public void removeMenu(Menu newValue){
        if (menus == null){
            menus = new MutableLiveData<>(new ArrayList<>());
        }
        ArrayList<Menu> totalMenu = menus.getValue();
        assert totalMenu != null;
        totalMenu.remove(newValue);
        menus.setValue(totalMenu);
    }

    public Menu getMenu(int i){
        if (menus == null){
            menus = new MutableLiveData<>(new ArrayList<>());
        }
        return menus.getValue().get(i);
    }

    public LiveData<ArrayList<Food>> getFoods(){
        if (foods == null){
            foods = new MutableLiveData<>();
        }
        return foods;
    }

    public void addFood(Food newValue){
        if (foods == null){
            foods = new MutableLiveData<>(new ArrayList<>());
        }
        ArrayList<Food> totalFoods = foods.getValue();
        assert totalFoods != null;
        totalFoods.add(newValue);
        foods.setValue(totalFoods);
    }

    public void removeFood(Food newValue){
        if (foods == null){
            foods = new MutableLiveData<>(new ArrayList<>());
        }
        ArrayList<Food> totalFood = foods.getValue();
        assert totalFood != null;
        totalFood.remove(newValue);
        foods.setValue(totalFood);
    }

    public Food getFood(int i){
        if (foods == null){
            foods = new MutableLiveData<>(new ArrayList<>());
        }
        return Objects.requireNonNull(foods.getValue()).get(i);
    }

    public Calendar getDaySelected(){
        return (Calendar) daySelected.clone();
    }

    public void setDaySelected(Calendar calendar){
        daySelected = calendar;
    }

}
