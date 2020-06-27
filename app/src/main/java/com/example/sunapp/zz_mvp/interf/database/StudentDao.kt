package com.example.sunapp.zz_mvp.interf.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao {

    @Insert
    fun insertStudents(vararg student: Student)
    @Update
    fun updateStudents(vararg student: Student)


}