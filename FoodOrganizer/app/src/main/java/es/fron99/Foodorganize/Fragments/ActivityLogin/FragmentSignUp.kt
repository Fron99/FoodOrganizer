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


class FragmentSignUp : Fragment() {
    private var activityLoginVM: ActivityLoginVM? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityLoginVM = ViewModelProvider(requireActivity()).get(ActivityLoginVM::class.java)

        asignOnClicks(view)

    }

    private fun asignOnClicks(view: View) {

        /****************************************************R.id.outlinedButton****************************************************/

        view.findViewById<Button>(R.id.outlinedButton).setOnClickListener {

            val textInputLayoutEmail = view.findViewById<TextInputLayout>(R.id.textInputLayoutEmail)
            val textInputLayoutPassword = view.findViewById<TextInputLayout>(R.id.textInputLayoutPassword)
            val textInputLayoutConfirmPassword = view.findViewById<TextInputLayout>(R.id.textInputLayoutConfirmPassword)


            val email = textInputLayoutEmail.editText?.text.toString()
            val password = textInputLayoutPassword.editText?.text.toString()
            val passwordConfirm = textInputLayoutConfirmPassword.editText?.text.toString()

            if (password == passwordConfirm){

                textInputLayoutConfirmPassword.isErrorEnabled = false

                if (checkPassword(password)) {
                    textInputLayoutPassword.isErrorEnabled = false

                    if (checkEmail(email)) {
                        textInputLayoutEmail.isErrorEnabled = false

                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                                email, password).addOnCompleteListener(requireActivity()) { task: Task<AuthResult?> ->
                            if (task.isSuccessful) {
                                activityLoginVM!!.changeLogginOk(true)
                            }
                        }

                    }else{
                        textInputLayoutEmail.error = "Email no valido. Tiene que ser @gmail.com"
                    }
                }else{
                    textInputLayoutPassword.error = "Contraseña no valida. Minimo 6 caracteres"
                }

            }else{
                textInputLayoutConfirmPassword.error = "Las contraseñas no coinciden."
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

