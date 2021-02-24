package es.fron99.foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.HorizontalCalendarView
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import es.fron99.foodorganize.Adapters.AdapterListCalendarMenus
import es.fron99.foodorganize.Models.Food
import es.fron99.foodorganize.Models.Menu
import es.fron99.foodorganize.Models.TimeMenu
import es.fron99.foodorganize.R
import es.fron99.foodorganize.ViewModels.ActivityTotalVM
import java.sql.Time
import java.util.*
import kotlin.collections.ArrayList

class FragmentCalendarMenus : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calendar_menus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(requireActivity()).get(ActivityTotalVM::class.java)

        val startDate = activityTotalVM.daySelected
        startDate.add(Calendar.DAY_OF_MONTH, -7)
        val endDate = activityTotalVM.daySelected
        endDate.add(Calendar.DAY_OF_MONTH, 7)

        val horizontalCalendar = HorizontalCalendar.Builder(requireActivity(), R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build()

        horizontalCalendar.centerCalendarToPosition(0)

        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {

            override fun onDateSelected(date: Calendar, position: Int) {
                activityTotalVM.daySelected = date
            }

            override fun onCalendarScroll(calendarView: HorizontalCalendarView?, dx: Int, dy: Int) {
                super.onCalendarScroll(calendarView, dx, dy)
            }

            override fun onDateLongClicked(date: Calendar?, position: Int): Boolean {
                activityTotalVM.daySelected = date
                return super.onDateLongClicked(date, position)
            }

        }


        val recycledLunch = view.findViewById<RecyclerView>(R.id.recycledTimeMenu)
        recycledLunch.layoutManager = LinearLayoutManager(context)
        recycledLunch.adapter = AdapterListCalendarMenus(context, activityTotalVM.timeMenus.value)

    }

}