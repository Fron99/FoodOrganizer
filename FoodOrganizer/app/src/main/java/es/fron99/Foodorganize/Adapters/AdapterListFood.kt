package es.fron99.Foodorganize.Adapters


import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.Repository.Repository
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM
import java.util.*


class AdapterListFood(context : ViewModelStoreOwner, dataSet: ArrayList<FoodDao>?) : RecyclerView.Adapter<AdapterListFood.ViewHolder>() {

    private var activityTotalVM : ActivityTotalVM
    private var food: ArrayList<FoodDao>


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
                    AlertDialog.Builder(view.context)
                            .setTitle("Se va a eliminar esta comida")
                            .setMessage("¿Estas seguro que desea eliminarla?")
                            .setPositiveButton("Si") { _: DialogInterface?, _: Int -> activityTotalVM.dropFood(FoodDao(food.idFood, "", "", 0))}
                            .setNegativeButton("No", null)
                            .show()
                }else{
                    activityTotalVM.foodsSelected = food
                    activityTotalVM.changeActivitySelected("FragmentCreateFood")
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
        activityTotalVM = ViewModelProvider(context).get(ActivityTotalVM::class.java)
    }

    fun changeData(dataSet: ArrayList<FoodDao>?){
        this.food.clear()
        this.food = ArrayList(dataSet)
        this.notifyDataSetChanged()
    }
}