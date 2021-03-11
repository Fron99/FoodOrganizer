package es.fron99.Foodorganize.Fragments.ActivityLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import es.fron99.Foodorganize.R
import es.fron99.Foodorganize.ViewModels.ActivityLoginVM


class FragmentSignIn : Fragment() {

    private lateinit var activityLoginVM: ActivityLoginVM

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

        view.findViewById<Button>(R.id.outlinedButton).setOnClickListener {

            val textInputLayoutEmail = view.findViewById<TextInputLayout>(R.id.textInputLayoutEmail)
            val textInputLayoutPassword = view.findViewById<TextInputLayout>(R.id.textInputLayoutPassword)

            val email = textInputLayoutEmail.editText?.text.toString()
            val password = textInputLayoutPassword.editText?.text.toString()

            if (checkPassword(password)) {
                textInputLayoutPassword.isErrorEnabled = false

                if (checkEmail(email)) {
                    textInputLayoutEmail.isErrorEnabled = false

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(
                            email, password).addOnCompleteListener(requireActivity()) { task: Task<AuthResult?> ->

                        if (task.isSuccessful) {
                            activityLoginVM.changeLogginOk(true)
                        }else{
                            Toast.makeText(requireContext(),"Credenciales no validas", Toast.LENGTH_LONG).show()
                        }

                    }

                }else{
                    textInputLayoutEmail.error = "Email no valido. Tiene que ser @gmail.com"
                }
            }else{
                textInputLayoutPassword.error = "Contraseña no valida. Minimo 6 caracteres"
            }

        }

    }

    private fun checkPassword(pass : String) : Boolean{ //TODO Add more checks
        return pass.length >= 6
    }


    private fun checkEmail(email : String) : Boolean{ //TODO Add more checks
        return email.contains("@gmail.com")
    }
}