package es.fron99.foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.fron99.foodorganize.Adapters.AdapterListFood
import es.fron99.foodorganize.Models.Food
import es.fron99.foodorganize.R
import es.fron99.foodorganize.ViewModels.ActivityTotalVM

class FragmentListFood : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM
    private lateinit var listFood : ArrayList<Food>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(this).get(ActivityTotalVM::class.java)

        listFood = ArrayList()
        listFood.add(Food("Huevo frito","Esto es un huevo frito con muchas cosas ricas en grasas"))
        listFood.add(Food("Macarrones con tomate","Unos buenos macarrones con tomates muy ricos"))
        listFood.add(Food("Pimiento relleno","Pimiento relleno de arroz con carne, riquisimo del fer"))
        listFood.add(Food("Huevo frito","Esto es un huevo frito con muchas cosas ricas en grasas"))
        listFood.add(Food("Macarrones con tomate","Unos buenos macarrones con tomates muy ricos"))
        listFood.add(Food("Pimiento relleno","Pimiento relleno de arroz con carne, riquisimo del fer"))
        listFood.add(Food("Huevo frito","Esto es un huevo frito con muchas cosas ricas en grasas"))
        listFood.add(Food("Macarrones con tomate","Unos buenos macarrones con tomates muy ricos"))
        listFood.add(Food("Pimiento relleno","Pimiento relleno de arroz con carne, riquisimo del fer"))
        listFood.add(Food("Huevo frito","Esto es un huevo frito con muchas cosas ricas en grasas"))
        listFood.add(Food("Macarrones con tomate","Unos buenos macarrones con tomates muy ricos"))
        listFood.add(Food("Pimiento relleno","Pimiento relleno de arroz con carne, riquisimo del fer"))

        var recyclerViewFood = view.findViewById<RecyclerView>(R.id.recyclerListFood)

        recyclerViewFood.layoutManager = LinearLayoutManager(context)
        recyclerViewFood.adapter = AdapterListFood(listFood)

    }

}