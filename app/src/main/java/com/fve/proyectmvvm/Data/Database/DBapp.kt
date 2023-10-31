package com.fve.proyectmvvm.Data.Database

import android.app.Application
import androidx.room.Room

class DBapp : Application() {
    val room = Room.databaseBuilder(this, Datb::class.java, "Info").build()
}