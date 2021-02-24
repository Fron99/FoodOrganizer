package es.fron99.Foodorganize.Fragments.ActivityLogin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import es.fron99.Foodorganize.R;
import es.fron99.Foodorganize.ViewModels.ActivityLoginVM;

public class InitFragment extends Fragment {

    private ActivityLoginVM activityLoginVM;

    public InitFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_init, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activityLoginVM = new ViewModelProvider(requireActivity()).get(ActivityLoginVM.class);

        Button btnSignIn = view.findViewById(R.id.btnSignIn);
        Button btnSignUp = view.findViewById(R.id.btnSignUp);

        btnSignIn.setOnClickListener(v -> activityLoginVM.changeFragmentSelected("SignIn"));

        btnSignUp.setOnClickListener(v -> activityLoginVM.changeFragmentSelected("SignUp"));

    }
}