package es.fron99.foodorganize.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import es.fron99.foodorganize.Fragments.ActivityLogin.FragmentSignIn;
import es.fron99.foodorganize.Fragments.ActivityLogin.FragmentSignUp;
import es.fron99.foodorganize.Fragments.ActivityLogin.InitFragment;
import es.fron99.foodorganize.R;
import es.fron99.foodorganize.ViewModels.ActivityLoginVM;

public class ActivityLogin extends AppCompatActivity {

    private ActivityLoginVM activityLoginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getActionBar() != null){
            getActionBar().hide();
        }

        activityLoginVM = new ViewModelProvider(this).get(ActivityLoginVM.class);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentLogin, InitFragment.class, null)
                .commit();

        asignObservers();

    }


    private void asignObservers(){

        Observer<String> observerFragmentSelected = s -> {
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
        };

        activityLoginVM.getFragmentSelected().observe(this, observerFragmentSelected);

        Context context = this;

        Observer<Boolean> observerLogginOk = bool -> {
            if (bool){

                finish();
                Intent goToActivityTotal = new Intent(context, ActivityTotal.class);
                startActivity(goToActivityTotal);

            }
        };

        activityLoginVM.getLogginOk().observe(this, observerLogginOk);

    }


}