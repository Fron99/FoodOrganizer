package es.fron99.Foodorganize.Fragments.ActivityLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import es.fron99.Foodorganize.Adapters.AdapterListCalendarMenus
import es.fron99.Foodorganize.Dao.Model.TimeMenuWithMenus
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityLoginVM
import java.util.*


class InitFragment : Fragment() {

    private var activityLoginVM: ActivityLoginVM? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_init, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityLoginVM = ViewModelProvider(requireActivity()).get(ActivityLoginVM::class.java)

        setOnClicks(view)

    }

    private fun setOnClicks(view : View){

        /****************************************************R.id.btnSignIn****************************************************/

        view.findViewById<Button>(R.id.btnSignIn).setOnClickListener {
            activityLoginVM!!.changeFragmentSelected("SignIn")
        }

        /****************************************************R.id.btnSignUp****************************************************/

        view.findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            activityLoginVM!!.changeFragmentSelected("SignUp")
        }



    }

}