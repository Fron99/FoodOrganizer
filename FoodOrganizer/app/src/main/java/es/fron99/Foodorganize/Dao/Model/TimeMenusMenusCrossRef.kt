package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(tableName = "TimeMenusMenusCrossRef",
        primaryKeys = ["idTimeMenu","idMenu"],
        foreignKeys = [
            ForeignKey(entity = TimeMenuDao::class,
                    parentColumns = ["idTimeMenu"],
                    childColumns = ["idTimeMenu"],
                    onDelete = ForeignKey.CASCADE),
            ForeignKey(entity = MenuDao::class,
                    parentColumns = ["idMenu"],
                    childColumns = ["idMenu"],
                    onDelete = ForeignKey.CASCADE)
        ],
        indices = [Index("idTimeMenu", unique = true),Index("idMenu", unique = true)]
)

class TimeMenusMenusCrossRef(
        @ColumnInfo(name = "idTimeMenu")
        var idTimeMenu:Int,
        @ColumnInfo(name = "idMenu")
        var idMenu:Int)