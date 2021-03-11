package es.fron99.Foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import es.fron99.Foodorganize.Adapters.AdapterListMenus
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM


class FragmentListMenus : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM
    private lateinit var recyclerViewMenus : RecyclerView
    private lateinit var adapterRecyclerViewMenus : AdapterListMenus
    private lateinit var listMenus: ArrayList<MenuWithFoods>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_menus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(requireActivity()).get(ActivityTotalVM::class.java)

        listMenus = if (activityTotalVM.menus.value != null){ArrayList(activityTotalVM.menus.value)}else{ArrayList()}

        inizialiteViews(view)

        setOnClicks(view)

        setObservers()

    }

    private fun inizialiteViews(view : View){

        /****************************************************R.id.recyclerListMenus****************************************************/

        recyclerViewMenus = view.findViewById(R.id.recyclerListMenus)
        recyclerViewMenus.layoutManager = LinearLayoutManager(context)
        adapterRecyclerViewMenus = AdapterListMenus(requireActivity(),listMenus)
        recyclerViewMenus.adapter = adapterRecyclerViewMenus


    }

    private fun setOnClicks(view : View){

        /****************************************************R.id.floatActionBtn****************************************************/

        view.findViewById<FloatingActionButton>(R.id.floatActionBtn).setOnClickListener {
            activityTotalVM.menusSelected = MenuWithFoods()
            activityTotalVM.changeActivitySelected("FragmentCreateMenu")
        }

    }

    private fun setObservers(){

        /****************************************************activityTotalVM.menus****************************************************/

        activityTotalVM.menus.observe(requireActivity(), {
            adapterRecyclerViewMenus.changeData(ArrayList(it))
        })

    }

}