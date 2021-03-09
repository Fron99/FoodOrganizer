package es.fron99.Foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import es.fron99.Foodorganize.Adapters.AdapterListCalendarMenus
import es.fron99.Foodorganize.Models.TimeMenu
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.Repository.UtilRepository
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM
import java.util.*
import kotlin.collections.ArrayList


class FragmentCalendarMenus : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM
    private lateinit var adapterRecyclerViewCalendarMenus : AdapterListCalendarMenus


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calendar_menus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(requireActivity()).get(ActivityTotalVM::class.java)

        var listTimeMenus: ArrayList<TimeMenu> = ArrayList()

        if (activityTotalVM.timeMenus?.value != null) {
            listTimeMenus.addAll(UtilRepository.parseListTimeMenuWithMenusToArrayListTimeMenu(activityTotalVM.timeMenus?.value!!))
        }
        val startDate = activityTotalVM.daySelected.clone() as Calendar
        startDate.add(Calendar.DAY_OF_MONTH, -7)
        val endDate = activityTotalVM.daySelected.clone() as Calendar
        endDate.add(Calendar.DAY_OF_MONTH, 7)

        val horizontalCalendar = HorizontalCalendar.Builder(view, R.id.calendarView).range(startDate, endDate).datesNumberOnScreen(5).defaultSelectedDate(activityTotalVM.daySelected.clone() as Calendar).build()
        horizontalCalendar.centerCalendarToPosition(0)
        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {

            override fun onDateSelected(date: Calendar, position: Int) {
                activityTotalVM.daySelected = date
                //activityTotalVM.remplaceTimeMenu(Repository().getTimeMenusByDate(requireContext(), date))
            }

        }

        val recycledTimeMenu = view.findViewById<RecyclerView>(R.id.recycledTimeMenu)
        recycledTimeMenu.layoutManager = LinearLayoutManager(context)
        adapterRecyclerViewCalendarMenus = AdapterListCalendarMenus(requireContext(), listTimeMenus)
        recycledTimeMenu.adapter = adapterRecyclerViewCalendarMenus

        activityTotalVM.timeMenus?.observe(requireActivity()) {
            adapterRecyclerViewCalendarMenus.changeData(UtilRepository.parseListTimeMenuWithMenusToArrayListTimeMenu(it))
        }

    }

}