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
import es.fron99.Foodorganize.Adapters.AdapterListFood
import es.fron99.Foodorganize.Adapters.AdapterListMenus
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM
import java.util.ArrayList

class FragmentListFood : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM
    private lateinit var recyclerViewFoods : RecyclerView
    private lateinit var adapterRecyclerViewFoods : AdapterListFood
    private lateinit var listFoods: ArrayList<FoodDao>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(requireActivity()).get(ActivityTotalVM::class.java)

        listFoods = if (activityTotalVM.foods.value != null){ArrayList(activityTotalVM.foods.value)}else{ArrayList()}

        inizialiteViews(view)

        setOnClicks(view)

        setObservers()

    }

    private fun inizialiteViews(view : View){

        /****************************************************R.id.recyclerListFood****************************************************/

        recyclerViewFoods = view.findViewById(R.id.recyclerListFood)
        recyclerViewFoods.layoutManager = LinearLayoutManager(context)
        adapterRecyclerViewFoods = AdapterListFood(requireActivity(),listFoods)
        recyclerViewFoods.adapter = adapterRecyclerViewFoods
    }

    private fun setOnClicks(view : View){

        /****************************************************R.id.floatActionBtn****************************************************/

        view.findViewById<FloatingActionButton>(R.id.floatActionBtn).setOnClickListener {
            activityTotalVM.foodsSelected = FoodDao()
            activityTotalVM.changeActivitySelected("FragmentCreateFood")
        }

    }

    private fun setObservers(){

        /****************************************************activityTotalVM.foods****************************************************/

        activityTotalVM.foods.observe(requireActivity(), {
            adapterRecyclerViewFoods.changeData(ArrayList(ArrayList(it)))
        })

    }

}