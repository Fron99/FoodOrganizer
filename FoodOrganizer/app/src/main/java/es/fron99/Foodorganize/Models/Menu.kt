package es.fron99.Foodorganize.Models

class Menu(var id: Int, var name:String, var smallDescription:String, var foods:ArrayList<Food>) {

    constructor(menu: Menu,foods: ArrayList<Food>) : this(menu.id, menu.name,menu.smallDescription,foods)

    var timeToPrepare : Int = 0
        get() {
            field = 0;
            for (i in foods.indices){
                field += foods[i].timeToPrepare
            }
            return field
        }

}