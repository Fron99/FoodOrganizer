package es.fron99.Foodorganize.Fragments.ActivityLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityLoginVM


class FragmentSignIn : Fragment() {
    private var activityLoginVM: ActivityLoginVM? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityLoginVM = ViewModelProvider(requireActivity()).get(ActivityLoginVM::class.java)
        asignOnClicks(view)
    }

    private fun asignOnClicks(view: View) {
        val btnSigIn = view.findViewById<Button>(R.id.outlinedButton)
        val textInputLayoutEmail = view.findViewById<View>(R.id.textInputLayoutEmail) as TextInputLayout
        val textInputLayoutPassword = view.findViewById<View>(R.id.textInputLayoutPassword) as TextInputLayout
        btnSigIn.setOnClickListener {
            val email = textInputLayoutEmail.editText!!.text.toString()
            val password = textInputLayoutPassword.editText!!.text.toString()
            if (password.length >= 6) {

                //TODO Añadir mas emails, dejar asi por ahora
                if (email.contains("@gmail.com")) {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(
                            email, password).addOnCompleteListener(requireActivity()) { task: Task<AuthResult?> ->

                        //TODO Mostrar mensaje de error
                        if (task.isSuccessful) {
                            activityLoginVM!!.changeLogginOk(true)
                        }
                    }
                } else {
                    textInputLayoutEmail.error = "The mail must be @gmail.com"
                }
            } else {
                textInputLayoutPassword.error = "The password must contain at least 6 characters"
            }
        }
    }
}