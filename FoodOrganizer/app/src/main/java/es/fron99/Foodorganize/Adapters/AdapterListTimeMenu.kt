package es.fron99.Foodorganize.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Models.Menu
import es.fron99.Foodorganize.R
import java.util.*


class AdapterListTimeMenu(dataSet: ArrayList<Menu>?) : RecyclerView.Adapter<AdapterListTimeMenu.ViewHolder>() {
    private val menus: ArrayList<Menu> = ArrayList(dataSet)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtViewNameMenu: TextView = view.findViewById(R.id.txtViewNameMenu)
        val txtViewSmallDescriptionMenu: TextView = view.findViewById(R.id.txtViewSmallDescriptionMenu)
        val txtViewTimePrepareMenu: TextView = view.findViewById(R.id.txtViewTimePrepareMenu)

        fun setTxtViewNameMenu(nameMenu: String?) {
            txtViewNameMenu.text = nameMenu
        }

        fun setTxtViewSmallDescriptionMenu(smallDescriptionMenu: String?) {
            txtViewSmallDescriptionMenu.text = smallDescriptionMenu
        }

        fun setTxtViewTimePrepareMenu(timePrepareMenu: String?) {
            txtViewTimePrepareMenu.text = timePrepareMenu
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.menu_card, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val menu = menus[position]
        viewHolder.setTxtViewNameMenu(menu.name)
        var descripcion = """
            ${menu.smallDescription}
            
            
            """.trimIndent()

        for (food in menu.foods) {
            descripcion += """
                - ${food.name}
                
                """.trimIndent()
        }
        viewHolder.setTxtViewSmallDescriptionMenu(descripcion)
        viewHolder.setTxtViewTimePrepareMenu(menu.timeToPrepare.toString() + "MIN")
    }

    override fun getItemCount(): Int {
        return menus.size
    }

}