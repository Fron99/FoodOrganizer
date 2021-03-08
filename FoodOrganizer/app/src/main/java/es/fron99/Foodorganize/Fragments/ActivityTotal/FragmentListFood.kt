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
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Models.Food
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.Repository.UtilRepository
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM
import java.util.ArrayList

class FragmentListFood : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM
    private lateinit var recyclerViewFoods : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(requireActivity()).get(ActivityTotalVM::class.java)

        var listFoods: ArrayList<Food> = ArrayList()

        if (activityTotalVM.getFoods().value != null){
            listFoods.addAll(UtilRepository.parseListFoodDaoToArrayListFood(activityTotalVM.getFoods().value!!))
        }

        recyclerViewFoods = view.findViewById(R.id.recyclerListFood)
        val layoutManager = LinearLayoutManager(context)
        recyclerViewFoods.layoutManager = layoutManager
        recyclerViewFoods.adapter = AdapterListFood(listFoods)

        val observerFood : Observer<List<FoodDao>> = Observer {
            listFoods.clear()
            listFoods.addAll(ArrayList(UtilRepository.parseListFoodDaoToArrayListFood(it)))
            recyclerViewFoods.adapter?.notifyDataSetChanged()
        }

        activityTotalVM.getFoods().observe(requireActivity(), observerFood)

        val floatActionBtn : FloatingActionButton = view.findViewById(R.id.floatActionBtn)

        floatActionBtn.setOnClickListener {
            activityTotalVM.changeFragmentSelected("FragmentCreateFood")

        }

    }

}