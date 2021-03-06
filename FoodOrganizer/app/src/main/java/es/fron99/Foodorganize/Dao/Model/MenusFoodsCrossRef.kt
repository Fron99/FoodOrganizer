package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "MenusFoodsCrossRef",
        primaryKeys = ["idMenu","idFood"],
        foreignKeys = [
                ForeignKey(entity = MenuDao::class,
                        parentColumns = ["idMenu"],
                        childColumns = ["idMenu"],
                        onDelete = ForeignKey.CASCADE),
                ForeignKey(entity = FoodDao::class,
                        parentColumns = ["idFood"],
                        childColumns = ["idFood"],
                        onDelete = ForeignKey.CASCADE)
        ])

class MenusFoodsCrossRef(
        @ColumnInfo(name = "idMenu")
        var idMenu:Int,
        @ColumnInfo(name = "idFood")
        var idFood:Int)