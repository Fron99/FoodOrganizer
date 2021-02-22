package es.fron99.foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.fron99.foodorganize.Adapters.AdapterListFood
import es.fron99.foodorganize.Adapters.AdapterListMenus
import es.fron99.foodorganize.Models.Food
import es.fron99.foodorganize.Models.Menu
import es.fron99.foodorganize.R
import es.fron99.foodorganize.ViewModels.ActivityTotalVM

class FragmentListMenus : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM
    private lateinit var listMenus : ArrayList<Menu>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_menus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityTotalVM = ViewModelProvider(this).get(ActivityTotalVM::class.java)

        val comidasDisponible: ArrayList<Food> = ArrayList()
        comidasDisponible.add(Food("",""))

        listMenus = ArrayList()
        listMenus.add(Menu("Huevo con papas fritas","Huevo frito con papas fritas de segundo", comidasDisponible))

        var recyclerViewFood = view.findViewById<RecyclerView>(R.id.recyclerListMenus)

        recyclerViewFood.layoutManager = LinearLayoutManager(context)
        recyclerViewFood.adapter = AdapterListMenus(listMenus)

    }

}