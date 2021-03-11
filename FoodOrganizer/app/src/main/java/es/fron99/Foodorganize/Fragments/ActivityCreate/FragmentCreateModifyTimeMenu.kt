package es.fron99.Foodorganize.Fragments.ActivityCreate

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import es.fron99.Foodorganize.Adapters.AdapterListFoodModify
import es.fron99.Foodorganize.Adapters.AdapterListMenusModify
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityCreateVM

//TODO Replantear todo, dejar esto solo para que funcione

class FragmentCreateModifyTimeMenu : Fragment() {

    private lateinit var fecha : TextView
    private lateinit var recyclerListMenusAsign : RecyclerView
    private lateinit var adapterRecyclerViewFoods : AdapterListMenusModify
    private lateinit var activityCreateVM: ActivityCreateVM
    private lateinit var timeMenuSelected : TimeMenuWithMenus
    private lateinit var textInputLayoutName : TextInputLayout
    private lateinit var textViewDate : MaterialTextView
    private lateinit var btnSave : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_time_menu, container, false)
    }

    @SuppressLint("CutPasteId", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityCreateVM = ViewModelProvider(requireActivity()).get(ActivityCreateVM::class.java)

        textInputLayoutName = view.findViewById(R.id.textInputLayoutName)
        textViewDate = view.findViewById(R.id.textViewDate)

        timeMenuSelected = activityCreateVM.timeMenuSelected

        btnSave = view.findViewById(R.id.btnSave)
        textInputLayoutName.editText?.setText(timeMenuSelected.timeMenu.name)
        textViewDate.text = "${timeMenuSelected.timeMenu.date.day}/${timeMenuSelected.timeMenu.date.month}/${timeMenuSelected.timeMenu.date.year}"

        recyclerListMenusAsign = view.findViewById(R.id.recyclerListMenusAsign)
        val layoutManager = LinearLayoutManager(context)
        recyclerListMenusAsign.layoutManager = layoutManager
        adapterRecyclerViewFoods = AdapterListMenusModify(requireActivity(), ArrayList(timeMenuSelected.menus))
        recyclerListMenusAsign.adapter = adapterRecyclerViewFoods

        fecha = view.findViewById(R.id.textViewDate)

        fecha.setOnClickListener {
            obtenerFecha()
        }

        btnSave.setOnClickListener {

            if (checkValues()){

                requireActivity().finish()

            }

        }


    }

    @SuppressLint("SetTextI18n")
    private fun obtenerFecha() {
        val recogerFecha = DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->
            val mesActual = month + 1
            val diaFormateado = if (dayOfMonth < 10) "0$dayOfMonth" else dayOfMonth.toString()
            val mesFormateado = if (mesActual < 10) "0$mesActual" else mesActual.toString()
            fecha.text = "$diaFormateado/$mesFormateado/$year"
        }, 2020, 2, 15)
        recogerFecha.show()
    }


    fun checkValues() : Boolean{

        var valid = false

        val name = textInputLayoutName.editText?.text.toString()

        if (name.length > 6) {
            textInputLayoutName.isErrorEnabled = false
        } else {
            textInputLayoutName.isErrorEnabled = true
            textInputLayoutName.error = "Longitud minima: 6"
        }


        if (!textInputLayoutName.isErrorEnabled){
            valid = true

        }

        return valid
    }

}