package es.fron99.foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.fron99.foodorganize.Adapters.AdapterListFood
import es.fron99.foodorganize.Models.Food
import es.fron99.foodorganize.R
import es.fron99.foodorganize.ViewModels.ActivityTotalVM
import java.util.ArrayList


class FragmentListFood : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM
    private lateinit var recyclerViewFood : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(this).get(ActivityTotalVM::class.java)

        recyclerViewFood = view.findViewById(R.id.recyclerListFood)
        var layoutManager = LinearLayoutManager(context)
        recyclerViewFood.layoutManager = layoutManager
        recyclerViewFood.adapter = AdapterListFood(activityTotalVM.foods.value)

        var observerFood : Observer<ArrayList<Food>> = Observer {
            recyclerViewFood.adapter?.notifyDataSetChanged()
        }

        activityTotalVM.foods.observe(requireActivity(), observerFood)

    }

}