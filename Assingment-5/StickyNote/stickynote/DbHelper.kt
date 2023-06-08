package com.example.stickynote

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION)
{
    companion object
    {
        var DB_NAME="user.db"
        var TABLE_NAME= "info"
        var ID="id"
        var TITLE = "title"
        var DESCRIPTION = "description"
        var DB_VERSION= 1
    }


    override fun onCreate(p0: SQLiteDatabase?) {
        var query ="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT,"+ DESCRIPTION + " TEXT" + ")"
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

        var upqery = " DROP TABLE IF EXITS " + TABLE_NAME
        p0!!.execSQL(upqery)
    }

  fun  savedata(m:Model):Long
  {
      var db = writableDatabase
      var value = ContentValues()
      value.put(TITLE,m.title)
      value.put(DESCRIPTION,m.des)

      var id = db.insert(TABLE_NAME, ID,value)
      return id
  }

    fun  viewdata(): ArrayList<Model>{
        var db =readableDatabase
        var list = ArrayList<Model>()
        var col = arrayOf(ID, TITLE, DESCRIPTION)
        var cursor:Cursor = db.query(TABLE_NAME,col,null,null,null,null,null,null)

        while (cursor.moveToNext())
        {
            var id1 =cursor.getInt(0)
            var task= cursor.getString(1)
            var des = cursor.getString(2)


            var m = Model()
            m.id = id1
            m.title = task
            m.des = des

            list.add(m)
        }

        return  list



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
        values.put(TITLE,m.title)
        values.put(DESCRIPTION,m.des)
        var updatequery  = "ID"+"="+m.id
        db.update(TABLE_NAME,values,updatequery,null)
    }
}