package es.fron99.Foodorganize.Dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import es.fron99.Foodorganize.Dao.Interfaces.*;
import es.fron99.Foodorganize.Dao.Model.FoodDao;
import es.fron99.Foodorganize.Dao.Model.MenuDao;
import es.fron99.Foodorganize.Dao.Model.Menu_FoodDao;
import es.fron99.Foodorganize.Dao.Model.TimeMenuDao;
import es.fron99.Foodorganize.Dao.Model.TimeMenu_MenuDao;


@Database(entities = {FoodDao.class, Menu_FoodDao.class, MenuDao.class, TimeMenu_MenuDao.class, TimeMenuDao.class}, version = 1)
public abstract class DatabaseFoodOrganize extends RoomDatabase {

    public abstract FoodDaoInt foodDao();
    public abstract Menu_FoodDaoInt menu_FoodDao();
    public abstract MenuDaoInt menuDao();
    public abstract TimeMenu_MenuDaoInt timeMenu_menuDao();
    public abstract TimeMenuDaoInt timeMenuDao();

    private static DatabaseFoodOrganize INSTANCE;

    public static DatabaseFoodOrganize getDatabase(final Context context){

        if (INSTANCE == null){
            synchronized (DatabaseFoodOrganize.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            //TODO Quitar allowMainThreadQueries
                            DatabaseFoodOrganize.class, "foodOrganize.db")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    //TODO Meter datos iniciales para testing
                                }
                            })
                            .allowMainThreadQueries().build();
                }
            }
        }

        return INSTANCE;

    }

}

