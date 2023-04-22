package com.example.realmedata

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication : Application() {

    override fun onCreate() {

        super.onCreate()
        //realm initialization
        Realm.init(this)

        //configuration database file

        var configuration =RealmConfiguration.Builder()
            .name("user.db")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()

        //set realm configuration
        Realm.setDefaultConfiguration(configuration)
    }
}