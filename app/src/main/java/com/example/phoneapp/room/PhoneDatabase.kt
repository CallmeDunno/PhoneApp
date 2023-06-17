package com.example.phoneapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PhoneNumber::class], version = 1)
abstract class PhoneDatabase : RoomDatabase() {
    abstract fun phoneDAO(): PhoneDAO
}