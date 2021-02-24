package es.fron99.Foodorganize.Fragments.ActivityLogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import es.fron99.Foodorganize.R;
import es.fron99.Foodorganize.ViewModels.ActivityLoginVM;

public class FragmentSignIn extends Fragment {

    private ActivityLoginVM activityLoginVM;


    public FragmentSignIn() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activityLoginVM = new ViewModelProvider(requireActivity()).get(ActivityLoginVM.class);
        asignOnClicks(view);


    }

    private void asignOnClicks(View view){

        Button btnSigIn = view.findViewById(R.id.outlinedButton);
        TextInputLayout textInputLayoutEmail = (TextInputLayout)view.findViewById(R.id.textInputLayoutEmail);
        TextInputLayout textInputLayoutPassword = (TextInputLayout)view.findViewById(R.id.textInputLayoutPassword);


        btnSigIn.setOnClickListener(v -> {

            String email = textInputLayoutEmail.getEditText().getText().toString();
            String password = textInputLayoutPassword.getEditText().getText().toString();

            if (password.length()>=6){

                //TODO Añadir mas emails, dejar asi por ahora
                if (email.contains("@gmail.com")){

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(
                            email,password).
                            addOnCompleteListener(requireActivity(), task -> {

                                //TODO Mostrar mensaje de error
                                if (task.isSuccessful()){
                                    activityLoginVM.changeLogginOk(true);
                                }

                            });

                }else{
                    textInputLayoutEmail.setError("The mail must be @gmail.com");
                }

            }else{
                textInputLayoutPassword.setError("The password must contain at least 6 characters");
            }

        });

    }


}