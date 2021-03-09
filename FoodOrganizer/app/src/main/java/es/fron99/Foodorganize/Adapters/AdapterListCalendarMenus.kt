package es.fron99.Foodorganize.Adapters

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Dao.Model.MenuDao
import es.fron99.Foodorganize.Dao.Model.TimeMenuDao
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM
import java.util.*
import kotlin.collections.ArrayList


class AdapterListCalendarMenus(context : ViewModelStoreOwner, dataSet: ArrayList<TimeMenuWithMenus>?) : RecyclerView.Adapter<AdapterListCalendarMenus.ViewHolder>() {

    private var activityTotalVM : ActivityTotalVM
    private var timeMenu: ArrayList<TimeMenuWithMenus>
    private lateinit var context : Context

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
        viewHolder.btnAddMenuTimeMenu.setOnClickListener {
            val popup = PopupMenu(context, viewHolder.btnAddMenuTimeMenu)
            popup.inflate(R.menu.menu_row_list_menu)
            popup.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.itemEliminar ->{
                        AlertDialog.Builder(it.context)
                                .setTitle("Se va a eliminar esta franja horaria")
                                .setMessage("¿Estas seguro que desea eliminarla?")
                                .setPositiveButton("Si") { _: DialogInterface?, _: Int -> activityTotalVM.dropTimeMenu(TimeMenuDao(timeMenu.timeMenu.idTimeMenu,"", Date()))}
                                .setNegativeButton("No", null)
                                .show()
                    }
                    R.id.itemModificar ->{
                        activityTotalVM.timeMenuSelected = timeMenu
                        activityTotalVM.changeActivitySelected("FragmentCreateTimeMenu")
                    }
                }
                return@setOnMenuItemClickListener true
            }
            popup.show()
        }
    }

    override fun getItemCount(): Int {
        return timeMenu.size
    }

    init {
        timeMenu = java.util.ArrayList(dataSet)
        activityTotalVM = ViewModelProvider(context).get(ActivityTotalVM::class.java)
        this.context = context as Context
    }

    fun changeData(dataSet: ArrayList<TimeMenuWithMenus>?){
        this.timeMenu.clear()
        this.timeMenu = ArrayList(dataSet)
        this.notifyDataSetChanged()
    }

}