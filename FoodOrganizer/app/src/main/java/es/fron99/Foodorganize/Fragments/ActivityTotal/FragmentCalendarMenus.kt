package es.fron99.Foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import es.fron99.Foodorganize.Adapters.AdapterListCalendarMenus
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM
import java.util.*


class FragmentCalendarMenus : Fragment() {

    private lateinit var activityTotalVM : ActivityTotalVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calendar_menus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityTotalVM = ViewModelProvider(requireActivity()).get(ActivityTotalVM::class.java)

        val startDate = activityTotalVM.daySelected.clone() as Calendar
        startDate.add(Calendar.DAY_OF_MONTH, -7)
        val endDate = activityTotalVM.daySelected.clone() as Calendar
        endDate.add(Calendar.DAY_OF_MONTH, 7)

        //TODO Solucionar error al girar la pantalla
        val horizontalCalendar = HorizontalCalendar.Builder(requireActivity(), R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build()

        horizontalCalendar.centerCalendarToPosition(0)

        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {

            override fun onDateSelected(date: Calendar, position: Int) {
                activityTotalVM.daySelected = date
            }

        }

        val recycledTimeMenu = view.findViewById<RecyclerView>(R.id.recycledTimeMenu)
        recycledTimeMenu.layoutManager = LinearLayoutManager(context)
        recycledTimeMenu.adapter = AdapterListCalendarMenus(context, activityTotalVM.timeMenus.value)

    }

}