package es.fron99.Foodorganize.Fragments.ActivityCreate

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.Repository.Repository
import es.fron99.Foodorganize.ViewModels.ActivityCreateVM


class FragmentCreateFood : Fragment() {

    private lateinit var activityCreateVM: ActivityCreateVM
    private lateinit var btnSave : Button
    private lateinit var textInputLayoutName : TextInputLayout
    private lateinit var textInputLayoutDescription : TextInputLayout
    private lateinit var textInputLayoutTimePrepare : TextInputLayout
    private lateinit var foodSelected : FoodDao

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_food, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityCreateVM = ViewModelProvider(requireActivity()).get(ActivityCreateVM::class.java)

        btnSave = view.findViewById(R.id.btnSave)
        textInputLayoutName = view.findViewById(R.id.textInputLayoutName)
        textInputLayoutDescription = view.findViewById(R.id.textInputLayoutDescription)
        textInputLayoutTimePrepare = view.findViewById(R.id.textInputLayoutTimePrepare)

        foodSelected = activityCreateVM.foodSelected

        textInputLayoutName.editText?.setText(foodSelected.name)
        textInputLayoutDescription.editText?.setText(foodSelected.smallDescription)
        textInputLayoutTimePrepare.editText?.setText(foodSelected.timeToPrepare.toString())

        btnSave.setOnClickListener {

            if (checkValues()){

                if (foodSelected.idFood == 0){
                    Repository().insertFoods(requireContext(), foodSelected)
                }else{
                    Repository().updateFoods(requireContext(), foodSelected)
                }
                requireActivity().finish()

            }

        }

    }

    fun checkValues() : Boolean{

        var valid = false

        val name = textInputLayoutName.editText?.text.toString()
        val description = textInputLayoutDescription.editText?.text.toString()
        val timeToPrepare = if (textInputLayoutTimePrepare.editText?.text.toString() == "") -1 else Integer.parseInt(textInputLayoutTimePrepare.editText?.text.toString())

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

        if (timeToPrepare >= 0) {
            textInputLayoutTimePrepare.isErrorEnabled = false
        } else {
            textInputLayoutTimePrepare.isErrorEnabled = true
            textInputLayoutTimePrepare.error = "El tiempo debe ser positivo"
        }

        if (!textInputLayoutName.isErrorEnabled &&
                !textInputLayoutDescription.isErrorEnabled &&
                !textInputLayoutTimePrepare.isErrorEnabled){
            valid = true
            foodSelected.name = name
            foodSelected.smallDescription = description
            foodSelected.timeToPrepare = timeToPrepare
        }

        return valid
    }


}