package es.fron99.foodorganize.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ActivityTotalVM extends ViewModel {

    private MutableLiveData<String> fragmentSelected;

    public ActivityTotalVM(){
        this.fragmentSelected = new MutableLiveData<>();
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

}
