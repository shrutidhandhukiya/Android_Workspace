package com.example.roomdb_activity.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")

class User
{
    @PrimaryKey(autoGenerate = true)
     var id = 0

    @ColumnInfo(name="user_name")
    var name=""

    @ColumnInfo(name="user_pass")
    var pass=""


}
