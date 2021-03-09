package es.fron99.Foodorganize.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Models.Food
import es.fron99.Foodorganize.Models.TimeMenu
import es.fron99.Foodorganize.R
import java.util.*


class AdapterListCalendarMenus(context: Context, dataSet: ArrayList<TimeMenu>?) : RecyclerView.Adapter<AdapterListCalendarMenus.ViewHolder>() {
    private var timeMenu: ArrayList<TimeMenu> = ArrayList(dataSet)
    private var context: Context = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtViewNameTimeMenu: TextView = view.findViewById(R.id.txtViewNameTimeMenu)
        val recycledMenusTimeMenu: RecyclerView = view.findViewById(R.id.recycledMenusTimeMenu)
        val btnAddMenuTimeMenu: Button = view.findViewById(R.id.btnAddMenuTimeMenu)

        fun setTxtViewNameTimeMenu(s: String?) {
            txtViewNameTimeMenu.text = s
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.time_menu_card, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val timeMenu = timeMenu[position]
        val menusTimeMenu = timeMenu.menus
        viewHolder.setTxtViewNameTimeMenu(timeMenu.name)
        viewHolder.recycledMenusTimeMenu.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewHolder.recycledMenusTimeMenu.adapter = AdapterListTimeMenu(menusTimeMenu)
        //TODO Añadir funcionalidad al boton
    }

    override fun getItemCount(): Int {
        return timeMenu.size
    }

    fun setTimeMenus(newValue: ArrayList<TimeMenu>?) {
        timeMenu.clear()
        timeMenu.addAll(newValue!!)
        notifyDataSetChanged()
    }

    fun changeData(dataSet: ArrayList<TimeMenu>?){
        this.timeMenu.clear()
        this.timeMenu = ArrayList(dataSet)
        this.notifyDataSetChanged()
    }

}