package com.example.phoneapp.room

import androidx.room.*

@Dao
interface PhoneDAO {
    @Query("SELECT * FROM Phone")
    fun getAllData(): List<PhoneNumber>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(phone: PhoneNumber)

    @Update
    fun updateData(phone: PhoneNumber)

    @Delete
    fun deleteData(phone: PhoneNumber)
}