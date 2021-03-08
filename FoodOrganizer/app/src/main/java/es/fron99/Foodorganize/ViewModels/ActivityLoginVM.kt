package es.fron99.Foodorganize.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ActivityLoginVM : ViewModel() {

    private var fragmentSelected: MutableLiveData<String>?
    private var logginOk: MutableLiveData<Boolean>?

    fun getFragmentSelected(): LiveData<String> {
        if (fragmentSelected == null) {
            fragmentSelected = MutableLiveData()
        }
        return this.fragmentSelected!!
    }

    val valueFragmentSelected: String?
        get() {
            if (fragmentSelected == null) {
                fragmentSelected = MutableLiveData()
            }
            return fragmentSelected!!.value
        }

    fun changeFragmentSelected(newValue: String) {
        if (fragmentSelected == null) {
            fragmentSelected = MutableLiveData()
        }
        fragmentSelected!!.value = newValue
    }

    fun getLogginOk(): LiveData<Boolean> {
        if (logginOk == null) {
            logginOk = MutableLiveData()
        }
        return this.logginOk!!
    }

    val valueLogginOk: Boolean?
        get() {
            if (logginOk == null) {
                logginOk = MutableLiveData()
            }
            return logginOk!!.value
        }

    fun changeLogginOk(newValue: Boolean) {
        if (logginOk == null) {
            logginOk = MutableLiveData()
        }
        logginOk!!.value = newValue
    }

    init {
        fragmentSelected = MutableLiveData()
        logginOk = MutableLiveData(false)
    }
}