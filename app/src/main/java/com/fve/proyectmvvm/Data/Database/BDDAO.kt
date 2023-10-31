package com.fve.proyectmvvm.Data.Database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface BDDAO {
    @Query("Select * From DBEn")
     fun getAll():List<DBEn>

    @Query("Select * From DBEn Where id= :id")
    fun getById(id:Int): DBEn

    @Update
    fun update(a:DBEn)


}