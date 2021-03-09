package es.fron99.Foodorganize.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.R
import java.util.*
import kotlin.collections.ArrayList


class AdapterListCalendarMenus(context: Context, dataSet: ArrayList<TimeMenuWithMenus>?) : RecyclerView.Adapter<AdapterListCalendarMenus.ViewHolder>() {
    private var timeMenu: ArrayList<TimeMenuWithMenus> = ArrayList(dataSet)
    private var context: Context = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtViewNameTimeMenu: TextView = view.findViewById(R.id.txtViewNameTimeMenu)
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
        viewHolder.setTxtViewNameTimeMenu(timeMenu.timeMenu.name)
        viewHolder.recycledMenusTimeMenu.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewHolder.recycledMenusTimeMenu.adapter = AdapterListTimeMenu(ArrayList(menusTimeMenu))
        //TODO Añadir funcionalidad al boton
    }

    override fun getItemCount(): Int {
        return timeMenu.size
    }


    fun changeData(dataSet: ArrayList<TimeMenuWithMenus>?){
        this.timeMenu.clear()
        this.timeMenu = ArrayList(dataSet)
        this.notifyDataSetChanged()
    }

}