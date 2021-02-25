package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TimeMenus")
class TimeMenuDao(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id:Int,
        @ColumnInfo(name = "Name")
        var name:String)