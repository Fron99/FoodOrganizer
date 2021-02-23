package es.fron99.foodorganize.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.fron99.foodorganize.Models.Menu;
import es.fron99.foodorganize.Models.TimeMenu;
import es.fron99.foodorganize.R;

public class AdapterListCalendarMenus extends RecyclerView.Adapter<AdapterListCalendarMenus.ViewHolder> {

    private ArrayList<TimeMenu> timeMenu;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtViewNameTimeMenu;
        private final RecyclerView recycledMenusTimeMenu;
        private final Button btnAddMenuTimeMenu;

        public ViewHolder(View view) {
            super(view);
            txtViewNameTimeMenu = view.findViewById(R.id.txtViewNameTimeMenu);
            recycledMenusTimeMenu = view.findViewById(R.id.recycledMenusTimeMenu);
            btnAddMenuTimeMenu = view.findViewById(R.id.btnAddMenuTimeMenu);
        }

        public TextView getTxtViewNameTimeMenu() {
            return txtViewNameTimeMenu;
        }

        public RecyclerView getRecycledMenusTimeMenu() {
            return recycledMenusTimeMenu;
        }

        public Button getBtnAddMenuTimeMenu() {
            return btnAddMenuTimeMenu;
        }

        public void setTxtViewNameTimeMenu(String s) {
            txtViewNameTimeMenu.setText(s);
        }

    }

    public AdapterListCalendarMenus(Context context, ArrayList<TimeMenu> dataSet) {
        this.timeMenu = new ArrayList<>(dataSet);
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterListCalendarMenus.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.time_menu_card, viewGroup, false);
        return new AdapterListCalendarMenus.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterListCalendarMenus.ViewHolder viewHolder, final int position) {
        TimeMenu timeMenu = this.timeMenu.get(position);
        ArrayList<Menu> menusTimeMenu = timeMenu.getMenus();
        viewHolder.setTxtViewNameTimeMenu(timeMenu.getName());
        viewHolder.getRecycledMenusTimeMenu().setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        viewHolder.getRecycledMenusTimeMenu().setAdapter(new AdapterListTimeMenu(menusTimeMenu));
        //TODO Añadir funcionalidad al boton
    }


    @Override
    public int getItemCount() {
        return timeMenu.size();
    }

}