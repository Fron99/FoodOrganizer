package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(tableName = "MenusFoodsCrossRef",
        primaryKeys = ["idMenu","idFood"]
)

class MenusFoodsCrossRef(
        @ColumnInfo(name = "idMenu")
        var idMenu:Int,
        @ColumnInfo(name = "idFood")
        var idFood:Int)