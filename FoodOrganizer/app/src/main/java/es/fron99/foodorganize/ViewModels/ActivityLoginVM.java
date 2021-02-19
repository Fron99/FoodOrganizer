package es.fron99.foodorganize.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ActivityLoginVM extends ViewModel {

    private MutableLiveData<String> fragmentSelected;
    private MutableLiveData<Boolean> logginOk;

    public ActivityLoginVM(){
        this.fragmentSelected = new MutableLiveData<>();
        this.logginOk = new MutableLiveData<>(false);
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

    public LiveData<Boolean> getLogginOk(){
        if (logginOk == null){
            logginOk = new MutableLiveData<>();
        }
        return logginOk;
    }

    public Boolean getValueLogginOk(){
        if (logginOk == null){
            logginOk = new MutableLiveData<>();
        }
        return logginOk.getValue();
    }

    public void changeLogginOk(Boolean newValue){
        if (logginOk == null){
            logginOk = new MutableLiveData<>();
        }
        logginOk.setValue(newValue);
    }

}
