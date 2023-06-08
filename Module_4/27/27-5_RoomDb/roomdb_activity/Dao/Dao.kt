package com.example.roomdb_activity.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdb_activity.Entity.User


@Dao
interface Daoclass
{
 @Insert
 fun insertdata(user: User?)

 @Query("select * from user")
 fun getUsers(): MutableList<User>

 @Update
 fun updateuser(user: User?)

 @Delete
 fun  deleteuser(user: User?)
}