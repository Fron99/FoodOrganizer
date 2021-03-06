package es.fron99.Foodorganize.Models

import es.fron99.Foodorganize.Dao.Model.TimeMenuDao
import java.util.*
import kotlin.collections.ArrayList

class TimeMenu(var id : Int, var name:String, var menus:ArrayList<Menu>, var date: Date){

    constructor(timeMenu: TimeMenu, menus: ArrayList<Menu>) : this(timeMenu.id, timeMenu.name,menus, timeMenu.date)

}