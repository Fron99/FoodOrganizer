package es.fron99.Foodorganize.Adapters


import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Models.Food
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.Repository.Repository
import java.util.*


class AdapterListFood(dataSet: ArrayList<Food>?) : RecyclerView.Adapter<AdapterListFood.ViewHolder>() {
    private var food: ArrayList<Food>

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtViewNameMenu: TextView = view.findViewById(R.id.nameFood)
        private val txtViewSmallDescriptionMenu: TextView = view.findViewById(R.id.smallDescriptionFood)
        private val imageView: ImageView = view.findViewById(R.id.imageView)
        private val optionsMenu: ImageView = view.findViewById(R.id.textViewOptions)

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

        fun getOptionsMenu() : ImageView {
            return optionsMenu
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
        viewHolder.getOptionsMenu().setOnClickListener { view: View ->
            val popup = PopupMenu(view.context, viewHolder.getOptionsMenu())
            popup.inflate(R.menu.menu_row_list_menu)
            popup.setOnMenuItemClickListener {
                if (it.itemId == R.id.itemEliminar) {
                    Repository().deleteFood(view.context, FoodDao(food.id, food.name, food.smallDescription, food.timeToPrepare))
                }
                return@setOnMenuItemClickListener true
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

    fun changeData(dataSet: ArrayList<Food>?){
        this.food.clear()
        this.food = ArrayList(dataSet)
        this.notifyDataSetChanged()
    }
}