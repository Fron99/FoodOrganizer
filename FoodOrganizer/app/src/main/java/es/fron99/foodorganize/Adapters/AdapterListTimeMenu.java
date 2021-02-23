package es.fron99.foodorganize.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.fron99.foodorganize.Models.Food;
import es.fron99.foodorganize.Models.Menu;
import es.fron99.foodorganize.R;

public class AdapterListTimeMenu extends RecyclerView.Adapter<AdapterListTimeMenu.ViewHolder> {

private ArrayList<Menu> menus;

public static class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView txtViewNameMenu, txtViewSmallDescriptionMenu, txtViewTimePrepareMenu;

    public ViewHolder(View view) {
        super(view);
        txtViewNameMenu = view.findViewById(R.id.txtViewNameMenu);
        txtViewSmallDescriptionMenu = view.findViewById(R.id.txtViewSmallDescriptionMenu);
        txtViewTimePrepareMenu = view.findViewById(R.id.txtViewTimePrepareMenu);
    }

    public TextView getTxtViewNameMenu() {
        return txtViewNameMenu;
    }

    public TextView getTxtViewSmallDescriptionMenu() {
        return txtViewSmallDescriptionMenu;
    }

    public void setTxtViewNameMenu(String nameMenu) {
        txtViewNameMenu.setText(nameMenu);
    }

    public void setTxtViewSmallDescriptionMenu(String smallDescriptionMenu) {
        txtViewSmallDescriptionMenu.setText(smallDescriptionMenu);
    }

    public TextView getTxtViewTimePrepareMenu() {
        return txtViewTimePrepareMenu;
    }

    public void setTxtViewTimePrepareMenu(String timePrepareMenu) {
        txtViewTimePrepareMenu.setText(timePrepareMenu);
    }

}

    public AdapterListTimeMenu(ArrayList<Menu> dataSet) {
        menus = new ArrayList<>(dataSet);
    }

    @NonNull
    @Override
    public AdapterListTimeMenu.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.menu_card, viewGroup, false);
        return new AdapterListTimeMenu.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterListTimeMenu.ViewHolder viewHolder, final int position) {
        Menu menu = this.menus.get(position);
        viewHolder.setTxtViewNameMenu(menu.getName());

        String descripcion = menu.getSmallDescription()+"\n\n";

        for (Food food :menu.getFoods()) {
            descripcion += "- "+food.getName()+"\n";
        }

        viewHolder.setTxtViewSmallDescriptionMenu(descripcion);
        viewHolder.setTxtViewTimePrepareMenu(menu.getTimeToPrepare()+"MIN");
    }


    @Override
    public int getItemCount() {
        return menus.size();
    }

}