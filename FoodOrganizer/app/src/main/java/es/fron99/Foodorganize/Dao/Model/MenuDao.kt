package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Menus")
class MenuDao(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int,
        @ColumnInfo(name = "Name")
        var name:String,
        @ColumnInfo(name = "SmallDescription")
        var smallDescription:String)