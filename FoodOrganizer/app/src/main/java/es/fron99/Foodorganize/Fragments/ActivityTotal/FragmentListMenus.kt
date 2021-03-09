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
import es.fron99.Foodorganize.Adapters.AdapterListMenus
import es.fron99.Foodorganize.Dao.Model.MenuDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM


class FragmentListMenus : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM
    private lateinit var recyclerViewMenus : RecyclerView
    private lateinit var adapterRecyclerViewMenus : AdapterListMenus

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_menus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(requireActivity()).get(ActivityTotalVM::class.java)

        var listMenus: ArrayList<MenuWithFoods> = ArrayList()

        if (activityTotalVM.menus?.value != null){
            listMenus.addAll(activityTotalVM.menus?.value!!)
        }

        recyclerViewMenus = view.findViewById(R.id.recyclerListMenus)
        val layoutManager = LinearLayoutManager(context)
        recyclerViewMenus.layoutManager = layoutManager
        adapterRecyclerViewMenus = AdapterListMenus(requireActivity(),listMenus)
        recyclerViewMenus.adapter = adapterRecyclerViewMenus

        val observerFood : Observer<List<MenuWithFoods>> = Observer {
            adapterRecyclerViewMenus.changeData(ArrayList(it))
        }

        activityTotalVM.menus?.observe(requireActivity(), observerFood)

    }

}