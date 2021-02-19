package es.fron99.foodorganize.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import es.fron99.foodorganize.R;

public class ActivityTotal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        this.getSupportActionBar().hide();

    }
}