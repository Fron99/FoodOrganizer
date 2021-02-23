package es.fron99.foodorganize.Fragments.ActivityTotal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import es.fron99.foodorganize.Adapters.AdapterListCalendarMenus
import es.fron99.foodorganize.Models.Food
import es.fron99.foodorganize.Models.Menu
import es.fron99.foodorganize.Models.TimeMenu
import es.fron99.foodorganize.R
import java.sql.Time
import java.util.*
import kotlin.collections.ArrayList

class FragmentCalendarMenus : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calendar_menus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val startDate = Calendar.getInstance()
        startDate.add(Calendar.DAY_OF_MONTH, 0)
        val endDate = Calendar.getInstance()
        endDate.add(Calendar.DAY_OF_MONTH, 6)

        val horizontalCalendar = HorizontalCalendar.Builder(requireActivity(), R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build()

        horizontalCalendar.centerCalendarToPosition(0)

        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {
            override fun onDateSelected(date: Calendar, position: Int) {
                if (date[Calendar.DAY_OF_MONTH] == Calendar.getInstance()[Calendar.DAY_OF_MONTH]) {
                }
            }
        }



        val comidasDisponible: ArrayList<Food> = ArrayList()
        comidasDisponible.add(Food("Huevo frito","Un huevo frito",5))
        comidasDisponible.add(Food("Papas fritas","Patatas fritas de paquete",3))
        comidasDisponible.add(Food("Papas fritas","Patatas fritas de paquete",3))
        comidasDisponible.add(Food("Papas fritas","Patatas fritas de paquete",3))

        var listMenus : ArrayList<Menu> = ArrayList()
        listMenus.add(Menu("Huevo con papas fritas","Huevo frito con papas fritas de segundo", comidasDisponible))
        listMenus.add(Menu("Huevo con papas fritas","Huevo frito con papas fritas de segundo", comidasDisponible))

        var listTimeMenu : ArrayList<TimeMenu> = ArrayList()
        listTimeMenu.add(TimeMenu("Desayunoaaaaaaaaaaaaaaaaaaaaaaaaaaa",listMenus))
        listTimeMenu.add(TimeMenu("Almuerzo",listMenus))
        listTimeMenu.add(TimeMenu("Cena",listMenus))

        var recycledLunch = view.findViewById<RecyclerView>(R.id.recycledTimeMenu)
        recycledLunch.layoutManager = LinearLayoutManager(context)
        recycledLunch.adapter = AdapterListCalendarMenus(context, listTimeMenu)


    }

}