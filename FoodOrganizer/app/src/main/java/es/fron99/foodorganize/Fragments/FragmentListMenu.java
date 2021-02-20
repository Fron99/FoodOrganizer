package es.fron99.foodorganize.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.shape.MarkerEdgeTreatment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import es.fron99.foodorganize.Adapters.AdapterListMenus;
import es.fron99.foodorganize.Models.Menu;
import es.fron99.foodorganize.R;


public class FragmentListMenu extends Fragment {

    public FragmentListMenu() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_MONTH,0);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DAY_OF_MONTH, 6);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(requireActivity(), R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        /*
        horizontalCalendar.centerCalendarToPosition(0);

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                if (date.get(Calendar.DAY_OF_MONTH) == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)){
                }
            }
        });


        ArrayList<Menu> menusLunch = new ArrayList<>(Arrays.asList(new Menu(),new Menu(),new Menu(),new Menu()));
        ArrayList<Menu> menusDinner = new ArrayList<>(Arrays.asList(new Menu(),new Menu(),new Menu(),new Menu()));

        RecyclerView recycledLunch = view.findViewById(R.id.recycledLunch);
        RecyclerView recycledDinner = view.findViewById(R.id.recycledDinner);

        recycledDinner.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        recycledDinner.setAdapter(new AdapterListMenus(menusDinner));

        recycledLunch.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        recycledLunch.setAdapter(new AdapterListMenus(menusLunch));

        */



    }
}