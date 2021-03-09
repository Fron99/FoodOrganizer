package es.fron99.Foodorganize.Fragments.ActivityCreate

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.Repository.Repository


class FragmentCreateFood : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSave = view.findViewById<Button>(R.id.btnSave)
        val textInputLayoutName = view.findViewById<TextInputLayout>(R.id.textInputLayoutName)
        val textInputLayoutDescription = view.findViewById<TextInputLayout>(R.id.textInputLayoutDescription)
        val textInputLayoutTimePrepare = view.findViewById<TextInputLayout>(R.id.textInputLayoutTimePrepare)

        btnSave.setOnClickListener {

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

                Repository().insertFoods(requireContext(), FoodDao(0,name, description,timeToPrepare))
                requireActivity().finish()

            }


        }

    }



}