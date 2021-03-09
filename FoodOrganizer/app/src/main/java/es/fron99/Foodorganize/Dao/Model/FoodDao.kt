package es.fron99.Foodorganize.Dao.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Foods")
class FoodDao(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "idFood")
        var idFood: Int,
        @ColumnInfo(name = "Name")
        var name: String,
        @ColumnInfo(name = "SmallDescription")
        var smallDescription: String,
        @ColumnInfo(name = "TimeToPrepare")
        var timeToPrepare: Int) : Serializable{

        constructor(): this(0,"","",0)
}