package es.fron99.Foodorganize.Adapters

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Models.Menu
import es.fron99.Foodorganize.Models.TimeMenu
import es.fron99.Foodorganize.R
import java.util.*


class AdapterListMenus(dataSet: ArrayList<Menu>?) : RecyclerView.Adapter<AdapterListMenus.ViewHolder>() {
    private var menus: ArrayList<Menu> = ArrayList(dataSet)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtViewNameMenu: TextView = view.findViewById(R.id.nameFood)
        val txtViewSmallDescriptionMenu: TextView = view.findViewById(R.id.smallDescriptionFood)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val optionsMenu: ImageView = view.findViewById(R.id.textViewOptions)

        fun setTxtViewNameMenu(nameMenu: String?) {
            txtViewNameMenu.text = nameMenu
        }

        fun setTxtViewSmallDescriptionMenu(smallDescriptionMenu: String?) {
            txtViewSmallDescriptionMenu.text = smallDescriptionMenu
        }

        fun setImageView(resourseId: Int) {
            imageView.setImageResource(resourseId)
        }

        fun setOptionsMenu(id: Int) {
            optionsMenu.setImageResource(id)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.row_list_food_and_menus, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val menu = menus[position]
        viewHolder.setTxtViewNameMenu(menu.name)
        viewHolder.setTxtViewSmallDescriptionMenu(menu.smallDescription)
        viewHolder.setImageView(R.drawable.icon_menus)
        viewHolder.optionsMenu.setOnClickListener { view: View ->
            val popup = PopupMenu(view.context, viewHolder.optionsMenu)
            popup.inflate(R.menu.menu_row_list_menu)
            popup.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.itemEliminar ->                         //handle menu1 click
                        return@setOnMenuItemClickListener true
                    R.id.itemModificar ->                         //handle menu2 click
                        return@setOnMenuItemClickListener true
                    else -> return@setOnMenuItemClickListener false
                }
            }
            popup.show()
        }
    }

    override fun getItemCount(): Int {
        return menus.size
    }

    fun changeData(dataSet: ArrayList<Menu>?){
        this.menus.clear()
        this.menus = ArrayList(dataSet)
        this.notifyDataSetChanged()
    }

}