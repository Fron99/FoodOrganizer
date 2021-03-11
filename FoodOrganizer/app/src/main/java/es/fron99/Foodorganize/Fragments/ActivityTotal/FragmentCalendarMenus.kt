package es.fron99.Foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import es.fron99.Foodorganize.Adapters.AdapterListCalendarMenus
import es.fron99.Foodorganize.Adapters.AdapterListFood
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM
import java.util.*
import kotlin.collections.ArrayList


class FragmentCalendarMenus : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM
    private lateinit var recyclerViewTimeMenus : RecyclerView
    private lateinit var adapterRecyclerViewCalendarMenus : AdapterListCalendarMenus
    private lateinit var listTimeMenus: ArrayList<TimeMenuWithMenus>
    private lateinit var horizontalCalendar : HorizontalCalendar


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calendar_menus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(requireActivity()).get(ActivityTotalVM::class.java)

        listTimeMenus = if (activityTotalVM.timeMenus().value != null){ ArrayList(activityTotalVM.timeMenus().value!!) }else{
            ArrayList()
        }

        inizialiteViews(view)

        setOnClicks(view)

        setObservers()

    }


    private fun inizialiteViews(view : View){

        /****************************************************R.id.recyclerTimeMenu****************************************************/

        recyclerViewTimeMenus = view.findViewById(R.id.recyclerTimeMenu)
        recyclerViewTimeMenus.layoutManager = LinearLayoutManager(context)
        adapterRecyclerViewCalendarMenus = AdapterListCalendarMenus(requireActivity(),listTimeMenus)
        recyclerViewTimeMenus.adapter = adapterRecyclerViewCalendarMenus

        /****************************************************R.id.calendarView****************************************************/

        val startDate = activityTotalVM.getValueDaySelected()?.clone() as Calendar
        startDate.add(Calendar.DAY_OF_MONTH, -7)
        val endDate = activityTotalVM.getValueDaySelected()?.clone() as Calendar
        endDate.add(Calendar.DAY_OF_MONTH, 7)

        horizontalCalendar = HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .defaultSelectedDate(activityTotalVM.getValueDaySelected()!!.clone() as Calendar)
                .build()
        horizontalCalendar.centerCalendarToPosition(0)


    }

    private fun setOnClicks(view : View){

        /****************************************************R.id.floatActionBtn****************************************************/

        view.findViewById<FloatingActionButton>(R.id.floatActionBtn).setOnClickListener {
            activityTotalVM.timeMenuSelected = TimeMenuWithMenus()
            activityTotalVM.changeActivitySelected("FragmentCreateTimeMenu")
        }

        /****************************************************horizontalCalendar.calendarListener****************************************************/

        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {

            override fun onDateSelected(date: Calendar, position: Int) {
                activityTotalVM.changeDaySelected(date)
            }

        }


    }

    private fun setObservers(){

        /****************************************************activityTotalVM.timeMenus****************************************************/

        activityTotalVM.timeMenus().observe(requireActivity(), {
            adapterRecyclerViewCalendarMenus.changeData(ArrayList(it))
        })

    }

}