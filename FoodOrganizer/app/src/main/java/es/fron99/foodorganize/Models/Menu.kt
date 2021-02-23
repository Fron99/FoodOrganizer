package es.fron99.foodorganize.Models

class Menu(var name:String, var smallDescription:String, var foods:ArrayList<Food>) {

    var timeToPrepare : Int

    init {
        timeToPrepare = 0

        for (i in foods.indices){
            timeToPrepare += foods.get(i).timeToPrepare
        }

    }

}