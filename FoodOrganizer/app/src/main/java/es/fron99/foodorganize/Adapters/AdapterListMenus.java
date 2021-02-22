package es.fron99.foodorganize.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.fron99.foodorganize.Models.Food;
import es.fron99.foodorganize.Models.Menu;
import es.fron99.foodorganize.R;

public class AdapterListMenus extends RecyclerView.Adapter<AdapterListMenus.ViewHolder>{

    private ArrayList<Menu> menus;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtViewNameMenu, txtViewSmallDescriptionMenu;
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            txtViewNameMenu = view.findViewById(R.id.nameFood);
            txtViewSmallDescriptionMenu = view.findViewById(R.id.smallDescriptionFood);
            imageView = view.findViewById(R.id.imageView);
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

    }

    public AdapterListMenus(ArrayList<Menu> dataSet) {
        menus = new ArrayList<>(dataSet);
    }

    @NonNull
    @Override
    public AdapterListMenus.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_list_food, viewGroup, false);
        return new AdapterListMenus.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterListMenus.ViewHolder viewHolder, final int position) {
        Menu menu = this.menus.get(position);
        viewHolder.setTxtViewNameMenu(menu.getName());
        viewHolder.setTxtViewSmallDescriptionMenu(menu.getSmallDescription());
        viewHolder.setImageView(R.drawable.icon_menus);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

}
