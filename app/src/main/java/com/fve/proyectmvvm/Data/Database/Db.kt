package com.fve.proyectmvvm.Data.Database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DBEn::class], version = 1
)
abstract class Datb : RoomDatabase() {
    abstract fun bdDAO(): BDDAO

}