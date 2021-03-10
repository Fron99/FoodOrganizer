package es.fron99.Foodorganize.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import es.fron99.Foodorganize.Dao.Model.FoodDao
import es.fron99.Foodorganize.Dao.Model.MenuWithFoods
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateModifyFood
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateModifyMenu
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateModifyTimeMenu
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityCreateVM

class ActivityCreateModify : AppCompatActivity() {

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
                            "FragmentCreateFood" -> FragmentCreateModifyFood::class.java
                            "FragmentCreateMenu" -> FragmentCreateModifyMenu::class.java
                            "FragmentCreateTimeMenu" -> FragmentCreateModifyTimeMenu::class.java
                            else -> FragmentCreateModifyFood::class.java
                        }

                        , null)
                .commit()


    }
}