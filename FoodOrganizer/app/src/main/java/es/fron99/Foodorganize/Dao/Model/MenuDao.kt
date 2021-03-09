package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Menus")
class MenuDao(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "idMenu")
        var idMenu: Int,
        @ColumnInfo(name = "Name")
        var name:String,
        @ColumnInfo(name = "SmallDescription")
        var smallDescription:String): Serializable {

        constructor(): this(0,"","")
}