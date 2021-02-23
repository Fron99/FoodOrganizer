package es.fron99.foodorganize.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
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
        private final ImageView imageView, optionsMenu;

        public ViewHolder(View view) {
            super(view);
            txtViewNameMenu = view.findViewById(R.id.nameFood);
            txtViewSmallDescriptionMenu = view.findViewById(R.id.smallDescriptionFood);
            imageView = view.findViewById(R.id.imageView);
            optionsMenu = view.findViewById(R.id.textViewOptions);
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

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(int resourseId) {
            imageView.setImageResource(resourseId);
        }

        public ImageView getOptionsMenu() {
            return optionsMenu;
        }

        public void setOptionsMenu(int id) {
            optionsMenu.setImageResource(id);
        }

    }

    public AdapterListMenus(ArrayList<Menu> dataSet) {
        menus = new ArrayList<>(dataSet);
    }

    @NonNull
    @Override
    public AdapterListMenus.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_list_food_and_menus, viewGroup, false);
        return new AdapterListMenus.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterListMenus.ViewHolder viewHolder, final int position) {
        Menu menu = this.menus.get(position);
        viewHolder.setTxtViewNameMenu(menu.getName());
        viewHolder.setTxtViewSmallDescriptionMenu(menu.getSmallDescription());
        viewHolder.setImageView(R.drawable.icon_menus);
        viewHolder.getOptionsMenu().setOnClickListener(view -> {
            PopupMenu popup = new PopupMenu(view.getContext(), viewHolder.getOptionsMenu());
            popup.inflate(R.menu.menu_row_list_menu);
            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.itemEliminar:
                        //handle menu1 click
                        return true;
                    case R.id.itemModificar:
                        //handle menu2 click
                        return true;
                    default:
                        return false;
                }
            });
            popup.show();

        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

}
