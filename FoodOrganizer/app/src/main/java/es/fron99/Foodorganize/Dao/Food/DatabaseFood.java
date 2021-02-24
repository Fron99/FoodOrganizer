package es.fron99.Foodorganize.Dao.Food;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.fron99.Foodorganize.Dao.Model.Food;

@Database(entities = {Food.class}, version = 1)
public abstract class DatabaseFood extends RoomDatabase {

    public abstract FoodDao foodDao();

    private static DatabaseFood INSTANCE;

    public static DatabaseFood getDatabase(final Context context){

        if (INSTANCE == null){
            synchronized (DatabaseFood.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            DatabaseFood.class, "crudPersons.db").allowMainThreadQueries().build();
                }
            }
        }

        return INSTANCE;

    }

}

