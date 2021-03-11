package es.fron99.Foodorganize.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

@Suppress("unused")
class ActivityLoginVM : ViewModel() {

    /************************************************FragmentSelected************************************************/

    private var fragmentSelected: MutableLiveData<String> = MutableLiveData()

    fun getFragmentSelected(): LiveData<String> {
        return this.fragmentSelected
    }

    fun valueFragmentSelected(): String? {
        return fragmentSelected.value
    }

    fun changeFragmentSelected(newValue: String) {
        fragmentSelected.value = newValue
    }

    /************************************************LogginOk************************************************/

    private var logginOk: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getLogginOk(): LiveData<Boolean> {
        return this.logginOk
    }

    fun getvalueLogginOk(): Boolean? {
        return logginOk.value
    }

    fun changeLogginOk(newValue: Boolean) {
        logginOk.value = newValue
    }

}