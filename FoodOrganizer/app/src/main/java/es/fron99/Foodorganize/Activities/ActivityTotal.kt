package es.fron99.Foodorganize.Activities

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        activityTotalVM = ViewModelProviders.of(this).get(ActivityTotalVM::class.java)

        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentTotal, FragmentCalendarMenus::class.java, null)
                .commit()

        val btmNavView = findViewById<BottomNavigationView>(R.id.btmNavView)

        btmNavView.setOnNavigationItemSelectedListener { item ->

            var classGet = when (item.itemId) {
                R.id.tabCalendarMenus -> FragmentCalendarMenus::class.java
                R.id.tabMenus -> FragmentListMenus::class.java
                R.id.tabFood -> FragmentListFood::class.java
                else -> FragmentCalendarMenus::class.java
            }

            supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentTotal, classGet, null)
                    .commit()

            true
        }

        //No hacer nada, esta puesto asi para que no lance una
        //excepcion al volver a seleccionar la opcion seleccionada
        btmNavView.setOnNavigationItemReselectedListener { }

    }


    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setTitle("Saldras de la aplicación")
                .setMessage("¿Estas seguro que desea salir?")
                .setPositiveButton("Si") { dialog: DialogInterface?, which: Int -> finish() }
                .setNegativeButton("No", null)
                .show()
    }


}