package com.example.realmedata

import io.realm.RealmObject

 open class Model : RealmObject() {

    var id :Int = 0
    var name: String = ""
    var pass :String = ""
}