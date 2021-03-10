package es.fron99.Foodorganize.Fragments.ActivityCreate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import es.fron99.Foodorganize.Adapters.AdapterListFood
import es.fron99.Foodorganize.Adapters.AdapterListFoodModify
import es.fron99.Foodorganize.Adapters.AdapterListMenus
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.Repository.Repository
import es.fron99.Foodorganize.ViewModels.ActivityCreateVM


class FragmentCreateModifyMenu : Fragment() {

    private lateinit var recyclerViewFoods : RecyclerView
    private lateinit var adapterRecyclerViewFoods : AdapterListFoodModify
    private lateinit var activityCreateVM: ActivityCreateVM
    private lateinit var menuSelected : MenuWithFoods
    private lateinit var textInputLayoutName : TextInputLayout
    private lateinit var textInputLayoutDescription : TextInputLayout
    private lateinit var btnSave : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityCreateVM = ViewModelProvider(requireActivity()).get(ActivityCreateVM::class.java)

        textInputLayoutName = view.findViewById(R.id.textInputLayoutName)
        textInputLayoutDescription = view.findViewById(R.id.textInputLayoutDescription)

        menuSelected = activityCreateVM.menuSelected

        btnSave = view.findViewById(R.id.btnSave)
        textInputLayoutName.editText?.setText(menuSelected.menu.name)
        textInputLayoutDescription.editText?.setText(menuSelected.menu.smallDescription)

        recyclerViewFoods = view.findViewById(R.id.recyclerListFoodsAsign)
        val layoutManager = LinearLayoutManager(context)
        recyclerViewFoods.layoutManager = layoutManager
        adapterRecyclerViewFoods = AdapterListFoodModify(requireActivity(), ArrayList(menuSelected.foods))
        recyclerViewFoods.adapter = adapterRecyclerViewFoods

        btnSave.setOnClickListener {

            if (checkValues()){

                requireActivity().finish()

            }

        }

    }

    fun checkValues() : Boolean{

        var valid = false

        val name = textInputLayoutName.editText?.text.toString()
        val description = textInputLayoutDescription.editText?.text.toString()

        if (name.length > 6) {
            textInputLayoutName.isErrorEnabled = false
        } else {
            textInputLayoutName.isErrorEnabled = true
            textInputLayoutName.error = "Longitud minima: 6"
        }


        if (description.length > 15) {
            textInputLayoutDescription.isErrorEnabled = false
        } else {
            textInputLayoutDescription.isErrorEnabled = true
            textInputLayoutDescription.error = "Longitud minima: 15"
        }


        if (!textInputLayoutName.isErrorEnabled &&
                !textInputLayoutDescription.isErrorEnabled){
            valid = true
            menuSelected.menu.name = name
            menuSelected.menu.smallDescription = description
        }

        return valid
    }

}