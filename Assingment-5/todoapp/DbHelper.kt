package com.example.todoapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DbHelper(context: Context):SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {
    companion object {
        var DB_NAME = "user.db"
        var TABLE_NAME ="info"
        var ID = "id"
        var TASK ="task"
        var DES ="des"
        var DB_VERSION = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {

        var query = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY,$TASK TEXT,$DES TEXT)"
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var upqery = "DROP TABLE EXISTS $TABLE_NAME"
        p0!!.execSQL(upqery)
    }

    fun savedata(m: Model): Long {
        var db = writableDatabase
        var values = ContentValues()
        values.put(TASK, m.task)
        values.put(DES, m.des)

        var id = db.insert(TABLE_NAME, ID, values)
        return id

    }

    fun viewdata(): ArrayList<Model> {
        var db = readableDatabase
        var list = ArrayList<Model>()
        var col = arrayOf(ID,TASK,DES)
        var cursor: Cursor = db.query(TABLE_NAME, col, null, null, null, null, null, null)

        while (cursor.moveToNext()) {
            var id = cursor.getInt(0)
            var task = cursor.getString(1)
            var des = cursor.getString(2)

            var m = Model()
            m.id = id
            m.task = task
            m.des = des

            list.add(m)
        }
        return list
    }

    fun deletedata(id: Int)
    {
        var db = writableDatabase
        var deletequery = "ID"+"="+id
        db.delete(TABLE_NAME,deletequery,null)
    }
    fun updatedata(m:Model)
    {
        var db = writableDatabase
        var values = ContentValues()
        values.put(ID,m.id)
        values.put(TASK,m.task)
        values.put(DES,m.des)
        var updatequery  = "ID"+"="+m.id
        db.update(TABLE_NAME,values,updatequery,null)
    }

}