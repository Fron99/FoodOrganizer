package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(tableName = "TimeMenusMenusCrossRef",
        primaryKeys = ["idTimeMenu","idMenu"])

class TimeMenusMenusCrossRef(
        @ColumnInfo(name = "idTimeMenu")
        var idTimeMenu:Int,
        @ColumnInfo(name = "idMenu")
        var idMenu:Int)