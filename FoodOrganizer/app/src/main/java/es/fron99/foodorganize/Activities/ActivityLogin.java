package es.fron99.foodorganize.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import es.fron99.foodorganize.Fragments.FragmentSignIn;
import es.fron99.foodorganize.Fragments.FragmentSignUp;
import es.fron99.foodorganize.Fragments.InitFragment;
import es.fron99.foodorganize.R;
import es.fron99.foodorganize.ViewModels.ActivityLoginVM;

public class ActivityLogin extends AppCompatActivity {

    private ActivityLoginVM activityLoginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activityLoginVM = new ViewModelProvider(this).get(ActivityLoginVM.class);

        this.getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentLogin, InitFragment.class, null)
                .commit();

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                switch (s){
                    case "SignIn":
                        getSupportFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragmentLogin, FragmentSignIn.class, null)
                                .addToBackStack("")
                                .commit();
                        break;

                    case "SignUp":
                        getSupportFragmentManager().beginTransaction()
                                .setReorderingAllowed(true)
                                .replace(R.id.fragmentLogin, FragmentSignUp.class, null)
                                .addToBackStack("")
                                .commit();
                        break;
                }
            }
        };

        activityLoginVM.getFragmentSelected().observe(this, observer);

    }
}