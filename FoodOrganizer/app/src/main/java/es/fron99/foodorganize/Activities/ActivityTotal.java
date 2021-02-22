package es.fron99.foodorganize.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import es.fron99.foodorganize.Fragments.ActivityTotal.FragmentCalendarMenus;
import es.fron99.foodorganize.Fragments.ActivityTotal.FragmentListFood;
import es.fron99.foodorganize.Fragments.ActivityTotal.FragmentListMenus;
import es.fron99.foodorganize.R;
import es.fron99.foodorganize.ViewModels.ActivityTotalVM;

public class ActivityTotal extends AppCompatActivity {

    private ActivityTotalVM activityTotalVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        activityTotalVM = new ViewModelProvider(this).get(ActivityTotalVM.class);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentTotal, FragmentCalendarMenus.class, null)
                .commit();

        BottomNavigationView btmNavView = findViewById(R.id.btmNavView);

        btmNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Class classGet = FragmentCalendarMenus.class;

                switch (item.getItemId()){
                    case R.id.tabCalendarMenus: classGet = FragmentCalendarMenus.class; break;
                    case R.id.tabMenus: classGet = FragmentListMenus.class; break;
                    case R.id.tabFood: classGet = FragmentListFood.class; break;
                }

                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentTotal, classGet, null)
                        .commit();

                return true;
            }
        });

        btmNavView.setOnNavigationItemReselectedListener(item -> {});

    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Saldras de la aplicación")
                .setMessage("¿Estas seguro que desea salir?")
                .setPositiveButton("Si", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .show();
    }

}