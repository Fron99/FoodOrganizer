package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Menus")
class Menu(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @ColumnInfo(name = "Name")
        var name:String,
        @ColumnInfo(name = "smallDescription")
        var smallDescription:String,
        @ColumnInfo(name = "Name")
        var foods:ArrayList<Food>) {

    var timeToPrepare : Int = 0

    init {

        for (i in foods.indices){
            timeToPrepare += foods[i].timeToPrepare
        }

    }

}