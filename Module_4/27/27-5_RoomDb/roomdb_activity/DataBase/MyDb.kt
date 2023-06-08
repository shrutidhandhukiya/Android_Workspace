package com.example.roomdb_activity.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb_activity.Dao.Daoclass
import com.example.roomdb_activity.Entity.User

@Database(entities = [User::class],version = 1)
abstract class MyDb :RoomDatabase()
{

    abstract fun daoClass(): Daoclass

}