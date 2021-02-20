package es.fron99.foodorganize.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.fron99.foodorganize.Models.Menu;
import es.fron99.foodorganize.R;

public class AdapterListMenus extends RecyclerView.Adapter<AdapterListMenus.ViewHolder>{

    private ArrayList<Menu> menus;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtViewNameMenu, txtViewSmallDescriptionMenu;

        public ViewHolder(View view) {
            super(view);
            txtViewNameMenu = view.findViewById(R.id.nameMenu);
            txtViewSmallDescriptionMenu = view.findViewById(R.id.smallDescriptionMenu);
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

    }

    public AdapterListMenus(ArrayList<Menu> dataSet) {
        menus = new ArrayList<>(dataSet);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.menu_card, viewGroup, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Menu menu = menus.get(position);
        viewHolder.setTxtViewNameMenu(menu.getNameMenu());
        viewHolder.setTxtViewSmallDescriptionMenu(menu.getSmallDescriptionMenu());

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

}
