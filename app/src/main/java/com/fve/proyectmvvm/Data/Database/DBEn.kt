package com.fve.proyectmvvm.Data.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DBEn(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val quote: String,
    val author: String
) {
}