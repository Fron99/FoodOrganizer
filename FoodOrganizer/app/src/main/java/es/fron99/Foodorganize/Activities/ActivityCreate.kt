package es.fron99.Foodorganize.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateFood
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateMenu
import es.fron99.Foodorganize.Fragments.ActivityCreate.FragmentCreateTimeMenu
import es.fron99.Foodorganize.Fragments.ActivityTotal.FragmentCalendarMenus
import es.fron99.Foodorganize.Fragments.ActivityTotal.FragmentListFood
import es.fron99.Foodorganize.Fragments.ActivityTotal.FragmentListMenus
import es.fron99.Foodorganize.R

class ActivityCreate : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val fragment = intent.extras?.getString("fragment")

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