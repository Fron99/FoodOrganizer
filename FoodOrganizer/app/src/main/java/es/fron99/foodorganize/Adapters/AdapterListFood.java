package es.fron99.foodorganize.Adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import es.fron99.foodorganize.Models.Food;
import es.fron99.foodorganize.R;

public class AdapterListFood extends RecyclerView.Adapter<AdapterListFood.ViewHolder>{

    private ArrayList<Food> food;

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

    public AdapterListFood(ArrayList<Food> dataSet) {
        food = new ArrayList<>(dataSet);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_list_food, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Food food = this.food.get(position);
        viewHolder.setTxtViewNameMenu(food.getName());
        viewHolder.setTxtViewSmallDescriptionMenu(food.getSmallDescription());
        viewHolder.setImageView(R.drawable.icon_food);
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

}