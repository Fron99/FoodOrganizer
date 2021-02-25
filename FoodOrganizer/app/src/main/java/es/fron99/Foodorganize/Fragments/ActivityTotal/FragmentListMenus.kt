package es.fron99.Foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Adapters.AdapterListMenus
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.Repository.Repository
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM

class FragmentListMenus : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_menus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(this).get(ActivityTotalVM::class.java)

        activityTotalVM.remplaceMenu(Repository().getMenus(requireContext()))

        val recyclerViewFood = view.findViewById<RecyclerView>(R.id.recyclerListMenus)
        recyclerViewFood.layoutManager = LinearLayoutManager(context)
        recyclerViewFood.adapter = AdapterListMenus(activityTotalVM.menus.value)

    }

}