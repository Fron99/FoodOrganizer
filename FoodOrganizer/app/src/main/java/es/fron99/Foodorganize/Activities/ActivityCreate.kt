package es.fron99.Foodorganize.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.ViewModelProvider
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateFood
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateMenu
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateTimeMenu
import es.fron99.Foodorganize.Fragments.ActivityTotal.FragmentCalendarMenus
import es.fron99.Foodorganize.Fragments.ActivityTotal.FragmentListFood
import es.fron99.Foodorganize.Fragments.ActivityTotal.FragmentListMenus
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityCreateVM
import es.fron99.Foodorganize.ViewModels.ActivityTotalVM

class ActivityCreate : AppCompatActivity() {

    private lateinit var activityCreateVM: ActivityCreateVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        activityCreateVM = ViewModelProvider(this).get(ActivityCreateVM::class.java)

        val fragment = intent.extras?.getString("fragment")
        val obj = intent.extras?.get("obj")


        if(obj is FoodDao){
            activityCreateVM.foodSelected = obj
        }else{
            if(obj is MenuWithFoods){
                activityCreateVM.menuSelected = obj
            }else{
                if(obj is TimeMenuWithMenus){
                    activityCreateVM.timeMenuSelected = obj
                }
            }
        }

        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer,

                        when (fragment) {
                            "FragmentCreateFood" -> FragmentCreateFood::class.java
                            "FragmentCreateMenu" -> FragmentCreateMenu::class.java
                            "FragmentCreateTimeMenu" -> FragmentCreateTimeMenu::class.java
                            else -> FragmentCreateFood::class.java
                        }

                        , null)
                .commit()


    }
}