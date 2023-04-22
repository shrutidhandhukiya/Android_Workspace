package com.example.finalsqllite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) :SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {

    companion object
    {
        var DB_NAME = "user.dp"
        var TABLE_NAME = "demo"
        var DB_VERSION = 1
        var ID ="id"
        var NAME = "name"
        var NUMBER = "number"

    }

    override fun onCreate(p0: SQLiteDatabase?) {

        var query = "CREATE TABLE " + TABLE_NAME +"("  + ID + "INTEGER PRIMARY KEY ," + NAME + "TEXT," + NUMBER + "TEXT" +   ")"
        p0!!.execSQL(query)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var upquery =  "DROP TABLE IF EXITS " + TABLE_NAME
        p0!!.execSQL(upquery)

    }

    fun savedata(m: Model): Long {
        var db = writableDatabase
        var values = ContentValues()
        values.put(NAME, m.name)
        values.put(NUMBER, m.num)

        return db.insert(TABLE_NAME, ID, values)
    }

}