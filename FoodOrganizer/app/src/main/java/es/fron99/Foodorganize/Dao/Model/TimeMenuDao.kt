package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "TimeMenus")
class TimeMenuDao(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "idTimeMenu")
        var idTimeMenu:Int,
        @ColumnInfo(name = "Name")
        var name:String,
        @ColumnInfo(name = "Date")
        var date : Date)