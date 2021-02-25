package es.fron99.Foodorganize.Models

class Menu(var id: Int, var name:String, var smallDescription:String, var foods:ArrayList<Food>) {

    var timeToPrepare : Int = 0

    init {

        for (i in foods.indices){
            timeToPrepare += foods[i].timeToPrepare
        }

    }

}