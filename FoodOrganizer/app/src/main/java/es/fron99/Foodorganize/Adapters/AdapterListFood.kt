package es.fron99.Foodorganize.Adapters


import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Models.Food
import es.fron99.Foodorganize.R
import java.util.*


class AdapterListFood(dataSet: ArrayList<Food>?) : RecyclerView.Adapter<AdapterListFood.ViewHolder>() {
    private val food: ArrayList<Food>

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtViewNameMenu: TextView
        val txtViewSmallDescriptionMenu: TextView
        val imageView: ImageView
        val optionsMenu: ImageView

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

        init {
            txtViewNameMenu = view.findViewById(R.id.nameFood)
            txtViewSmallDescriptionMenu = view.findViewById(R.id.smallDescriptionFood)
            imageView = view.findViewById(R.id.imageView)
            optionsMenu = view.findViewById(R.id.textViewOptions)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.row_list_food_and_menus, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val food = food[position]
        viewHolder.setTxtViewNameMenu(food.name)
        viewHolder.setTxtViewSmallDescriptionMenu(food.smallDescription)
        viewHolder.setImageView(R.drawable.icon_food)
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
        return food.size
    }

    init {
        food = ArrayList(dataSet)
    }
}