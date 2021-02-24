package es.fron99.foodorganize.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import es.fron99.foodorganize.Fragments.ActivityLogin.FragmentSignIn
import es.fron99.foodorganize.Fragments.ActivityLogin.FragmentSignUp
import es.fron99.foodorganize.Fragments.ActivityLogin.InitFragment
import es.fron99.foodorganize.R
import es.fron99.foodorganize.ViewModels.ActivityLoginVM

class ActivityLogin : AppCompatActivity() {

    private lateinit var activityLoginVM: ActivityLoginVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (actionBar != null) {
            actionBar!!.hide()
        }

        activityLoginVM = ViewModelProvider(this).get(ActivityLoginVM::class.java)

        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentLogin, InitFragment::class.java, null)
                .commit()

        asignObservers()

    }

    private fun asignObservers() {

        val observerFragmentSelected = Observer { s: String? ->

            var fragmentToGo = when (s) {
                "SignIn" -> FragmentSignIn::class.java
                "SignUp" -> FragmentSignUp::class.java
                else -> FragmentSignIn::class.java
            }

            supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentLogin, fragmentToGo, null)
                    .addToBackStack("")
                    .commit()
        }

        activityLoginVM.fragmentSelected.observe(this, observerFragmentSelected)

        val context: Context = this

        val observerLogginOk = Observer { bool: Boolean ->
            if (bool) {
                finish()
                val goToActivityTotal = Intent(context, ActivityTotal::class.java)
                startActivity(goToActivityTotal)
            }
        }

        activityLoginVM.logginOk.observe(this, observerLogginOk)

    }

}