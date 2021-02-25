package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
        tableName = "TimeMenus_Menus",
        primaryKeys = ["idTimeMenu", "idMenu"],
        foreignKeys = [

                        ForeignKey(entity = TimeMenuDao::class,
                        parentColumns = ["id"],
                        childColumns = ["idTimeMenu"],
                        onDelete = ForeignKey.CASCADE),

                        ForeignKey(entity = MenuDao::class,
                        parentColumns = ["id"],
                        childColumns = ["idMenu"],
                        onDelete = ForeignKey.CASCADE)
        ]
)

class TimeMenu_MenuDao(
        @ColumnInfo(name = "idTimeMenu")
        var idTimeMenu:Int,
        @ColumnInfo(name = "idMenu")
        var idMenu:Int)