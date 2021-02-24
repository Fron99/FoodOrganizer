package es.fron99.foodorganize.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import es.fron99.foodorganize.Models.Food;
import es.fron99.foodorganize.Models.Menu;
import es.fron99.foodorganize.Models.TimeMenu;

public class ActivityTotalVM extends ViewModel {

    private MutableLiveData<String> fragmentSelected;
    private MutableLiveData<ArrayList<TimeMenu>> timeMenu;
    private MutableLiveData<ArrayList<Menu>> menus;
    private MutableLiveData<ArrayList<Food>>foods;

    public ActivityTotalVM(){
        this.fragmentSelected = new MutableLiveData<>();
        this.timeMenu = new MutableLiveData<>();
        this.menus = new MutableLiveData<>();
        this.foods = new MutableLiveData<>();

        ArrayList<Food> listFood = new ArrayList<>();
        listFood.add(new Food("Huevo frito", "Esto es un huevo frito con muchas cosas ricas en grasas",5));
        listFood.add(new Food("Macarrones con tomate", "Unos buenos macarrones con tomates muy ricos",5));
        listFood.add(new Food("Pimiento relleno", "Pimiento relleno de arroz con carne, riquisimo del fer",5));
        listFood.add(new Food("Huevo frito", "Esto es un huevo frito con muchas cosas ricas en grasas",5));
        foods.setValue(listFood);






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
            timeMenu = new MutableLiveData<>();
        }
        return timeMenu;
    }

    public void addTimeMenu(TimeMenu newValue){
        if (timeMenu == null){
            timeMenu = new MutableLiveData<>();
        }
        ArrayList<TimeMenu> totalTimeMenu = timeMenu.getValue();
        totalTimeMenu.add(newValue);
        timeMenu.setValue(totalTimeMenu);
    }

    public void removeTimeMenu(TimeMenu newValue){
        if (timeMenu == null){
            timeMenu = new MutableLiveData<>();
        }
        ArrayList<TimeMenu> totalTimeMenu = timeMenu.getValue();
        totalTimeMenu.remove(newValue);
        timeMenu.setValue(totalTimeMenu);
    }

    public TimeMenu getTimeMenu(int i){
        if (timeMenu == null){
            timeMenu = new MutableLiveData<>();
        }
        return timeMenu.getValue().get(i);
    }

    public LiveData<ArrayList<Menu>> getMenus(){
        if (menus == null){
            menus = new MutableLiveData<>();
        }
        return menus;
    }

    public void addMenu(Menu newValue){
        if (menus == null){
            menus = new MutableLiveData<>();
        }
        ArrayList<Menu> totalMenus = menus.getValue();
        totalMenus.add(newValue);
        menus.setValue(totalMenus);
    }

    public void removeMenu(Menu newValue){
        if (menus == null){
            menus = new MutableLiveData<>();
        }
        ArrayList<Menu> totalMenu = menus.getValue();
        totalMenu.remove(newValue);
        menus.setValue(totalMenu);
    }

    public Menu getMenu(int i){
        if (menus == null){
            menus = new MutableLiveData<>();
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
            foods = new MutableLiveData<>();
        }
        ArrayList<Food> totalFoods = foods.getValue();
        totalFoods.add(newValue);
        foods.setValue(totalFoods);
    }

    public void removeFood(Food newValue){
        if (foods == null){
            foods = new MutableLiveData<>();
        }
        ArrayList<Food> totalFood = foods.getValue();
        totalFood.remove(newValue);
        foods.setValue(totalFood);
    }

    public Food getFood(int i){
        if (foods == null){
            foods = new MutableLiveData<>();
        }
        return foods.getValue().get(i);
    }


}
