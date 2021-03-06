package es.fron99.Foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Adapters.AdapterListFood
import es.fron99.Foodorganize.Models.Food

import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.Repository.Repository
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM
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

        activityTotalVM = ViewModelProviders.of(requireActivity()).get(ActivityTotalVM::class.java)


        recyclerViewFood = view.findViewById(R.id.recyclerListFood)
        val layoutManager = LinearLayoutManager(context)
        recyclerViewFood.layoutManager = layoutManager
        //recyclerViewFood.adapter = AdapterListFood(activityTotalVM.foods.value)

        val observerFood : Observer<ArrayList<Food>> = Observer {
            recyclerViewFood.adapter?.notifyDataSetChanged()
        }

        //activityTotalVM.foods.observe(requireActivity(), observerFood)

    }

}