package es.fron99.Foodorganize.Dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Calendar;
import java.util.Date;

import es.fron99.Foodorganize.Dao.Converters.ConverterDate;
import es.fron99.Foodorganize.Dao.Interfaces.FoodDaoInt;
import es.fron99.Foodorganize.Dao.Interfaces.MenuDaoInt;
import es.fron99.Foodorganize.Dao.Interfaces.TimeMenuDaoInt;
import es.fron99.Foodorganize.Dao.Model.FoodDao;
import es.fron99.Foodorganize.Dao.Model.MenuDao;
import es.fron99.Foodorganize.Dao.Model.MenusFoodsCrossRef;
import es.fron99.Foodorganize.Dao.Model.TimeMenuDao;
import es.fron99.Foodorganize.Dao.Model.TimeMenusMenusCrossRef;


@Database(entities = {FoodDao.class, MenuDao.class, MenusFoodsCrossRef.class, TimeMenuDao.class, TimeMenusMenusCrossRef.class}, version = 1, exportSchema = false)
@TypeConverters(ConverterDate.class)
public abstract class DatabaseFoodOrganize extends RoomDatabase {

    public abstract FoodDaoInt foodDao();
    public abstract MenuDaoInt menuDao();
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

                                    for (int i = 0; i < 50; i++ )
                                        db.execSQL("INSERT INTO Foods(Name, SmallDescription, TimeToPrepare) VALUES ('Comida Ejemplo "+i+"','Descripcion de comida de ejemplo',5)");

                                    for (int i = 0; i < 50; i++ )
                                        db.execSQL("INSERT INTO Menus(Name, SmallDescription) VALUES ('Menu Ejemplo "+i+"','Descripcion de comida de ejemplo')");

                                    for (int i = 1; i < 50; i++ )
                                        db.execSQL("INSERT INTO MenusFoodsCrossRef(idMenu, idFood) VALUES ("+i+","+i+")");

                                    Calendar date = Calendar.getInstance();
                                    Date dateDate = new Date(date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH));

                                    for (int i = 0; i < 3; i++ )
                                        db.execSQL("INSERT INTO TimeMenus(Name, Date) VALUES ('Franja "+i+"',"+dateDate.getTime()+")");

                                    date.add(Calendar.DAY_OF_MONTH, 1);
                                    dateDate = new Date(date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH));
                                    db.execSQL("INSERT INTO TimeMenus(Name, Date) VALUES ('Franja',"+dateDate.getTime()+")");

                                    for (int i = 1; i < 5; i++ )
                                        db.execSQL("INSERT INTO TimeMenusMenusCrossRef(idTimeMenu, idMenu) VALUES ("+i+","+i+")");

                                }
                            })
                            .allowMainThreadQueries().build();
                }
            }
        }

        return INSTANCE;

    }

}

