package es.fron99.Foodorganize.Adapters

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
import es.fron99.Foodorganize.Dao.Model.MenuDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM
import java.util.*


class AdapterListMenus(context : ViewModelStoreOwner, dataSet: ArrayList<MenuWithFoods>?) : RecyclerView.Adapter<AdapterListMenus.ViewHolder>() {

    private var activityTotalVM : ActivityTotalVM
    private var menus: ArrayList<MenuWithFoods>

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
        viewHolder.setTxtViewNameMenu(menu.menu.name)
        viewHolder.setTxtViewSmallDescriptionMenu(menu.menu.smallDescription)
        viewHolder.setImageView(R.drawable.icon_menus)
        viewHolder.optionsMenu.setOnClickListener { view: View ->
            val popup = PopupMenu(view.context, viewHolder.optionsMenu)
            popup.inflate(R.menu.menu_row_list_menu)
            popup.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.itemEliminar ->{
                        AlertDialog.Builder(view.context)
                                .setTitle("Se va a eliminar este menu")
                                .setMessage("¿Estas seguro que desea eliminarla?")
                                .setPositiveButton("Si") { _: DialogInterface?, _: Int -> activityTotalVM.dropMenu(MenuDao(menu.menu.idMenu,"",""))}
                                .setNegativeButton("No", null)
                                .show()
                    }
                    R.id.itemModificar ->{
                        activityTotalVM.menusSelected = menu
                        activityTotalVM.changeActivitySelected("FragmentCreateMenu")
                    }
                }
                return@setOnMenuItemClickListener true
            }
            popup.show()
        }
    }

    override fun getItemCount(): Int {
        return menus.size
    }

    init {
        menus = ArrayList(dataSet)
        activityTotalVM = ViewModelProvider(context).get(ActivityTotalVM::class.java)
    }

    fun changeData(dataSet: ArrayList<MenuWithFoods>?){
        this.menus.clear()
        this.menus = ArrayList(dataSet)
        this.notifyDataSetChanged()
    }

}