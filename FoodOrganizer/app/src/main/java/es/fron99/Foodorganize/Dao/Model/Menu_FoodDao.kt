package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
        tableName = "Menus_Foods",
        primaryKeys = ["idMenu", "idFood"],
        foreignKeys = [
                        ForeignKey(entity = MenuDao::class,
                        parentColumns = ["id"],
                        childColumns = ["idMenu"],
                        onDelete = ForeignKey.CASCADE),

                        ForeignKey(entity = FoodDao::class,
                        parentColumns = ["id"],
                        childColumns = ["idFood"],
                        onDelete = ForeignKey.CASCADE)
                      ]
)

class Menu_FoodDao(
        @ColumnInfo(name = "idMenu")
        var idMenu:Int,
        @ColumnInfo(name = "idFood")
        var idFood:Int)