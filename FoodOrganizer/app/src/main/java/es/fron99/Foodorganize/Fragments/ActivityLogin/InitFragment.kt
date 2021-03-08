package es.fron99.Foodorganize.Fragments.ActivityLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityLoginVM


class InitFragment : Fragment() {

    private var activityLoginVM: ActivityLoginVM? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_init, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityLoginVM = ViewModelProvider(requireActivity()).get(ActivityLoginVM::class.java)
        val btnSignIn = view.findViewById<Button>(R.id.btnSignIn)
        val btnSignUp = view.findViewById<Button>(R.id.btnSignUp)
        btnSignIn.setOnClickListener { activityLoginVM!!.changeFragmentSelected("SignIn") }
        btnSignUp.setOnClickListener { activityLoginVM!!.changeFragmentSelected("SignUp") }
    }
}