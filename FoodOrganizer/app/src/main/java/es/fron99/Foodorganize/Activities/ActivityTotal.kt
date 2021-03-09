package es.fron99.Foodorganize.Activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateFood
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateMenu
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateTimeMenu
import es.fron99.Foodorganize.Fragments.ActivityTotal.FragmentCalendarMenus
import es.fron99.Foodorganize.Fragments.ActivityTotal.FragmentListFood
import es.fron99.Foodorganize.Fragments.ActivityTotal.FragmentListMenus
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM

class ActivityTotal : AppCompatActivity() {

    private lateinit var activityTotalVM: ActivityTotalVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)

        activityTotalVM = ViewModelProvider(this).get(ActivityTotalVM::class.java)

        initFragment()

        initBtmNavView()

        setObservers()

    }

    fun initFragment(){

        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentTotal,

                        when (activityTotalVM.fragmentSelected?.value) {
                            "FragmentCalendarMenus" -> FragmentCalendarMenus::class.java
                            "FragmentListMenus" -> FragmentListMenus::class.java
                            "FragmentListFood" -> FragmentListFood::class.java
                            else -> FragmentCalendarMenus::class.java
                        }

                        , null)
                .commit()

    }

    fun initBtmNavView(){

        val btmNavView = findViewById<BottomNavigationView>(R.id.btmNavView)

        btmNavView.setOnNavigationItemSelectedListener { item ->

            supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentTotal,

                            when (item.itemId) {
                                R.id.tabCalendarMenus -> FragmentCalendarMenus::class.java
                                R.id.tabMenus -> FragmentListMenus::class.java
                                R.id.tabFood -> FragmentListFood::class.java
                                else -> FragmentCalendarMenus::class.java
                            }

                            ,null)
                    .commit()

            true
        }

        //No hacer nada, esta puesto asi para que no lance una
        //excepcion al volver a seleccionar la opcion seleccionada
        btmNavView.setOnNavigationItemReselectedListener { }

    }

    fun setObservers(){

        activityTotalVM.fragmentSelected?.observe(this, {
            supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentTotal,
                            when (it) {
                                "FragmentCalendarMenus" -> FragmentCalendarMenus::class.java
                                "FragmentListMenus" -> FragmentListMenus::class.java
                                "FragmentListFood" -> FragmentListFood::class.java
                                else -> FragmentCalendarMenus::class.java
                            }
                            , null)
                    .commit()
        })

        activityTotalVM.activitySelected?.observe(this, {
            if (!it.equals("Init")){
                val i = Intent(this, ActivityCreate::class.java)
                i.putExtra("fragment",it)
                i.putExtra("obj",
                        when (it) {
                            "FragmentCreateFood" -> activityTotalVM.foodsSelected
                            "FragmentCreateMenu" -> activityTotalVM.menusSelected
                            "FragmentCreateTimeMenu" -> activityTotalVM.timeMenuSelected
                            else -> activityTotalVM.foodsSelected
                        }
                        )
                startActivity(i);
            }
        })

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setTitle("Saldras de la aplicación")
                .setMessage("¿Estas seguro que desea salir?")
                .setPositiveButton("Si") { _: DialogInterface?, _: Int -> finish() }
                .setNegativeButton("No", null)
                .show()
    }

}