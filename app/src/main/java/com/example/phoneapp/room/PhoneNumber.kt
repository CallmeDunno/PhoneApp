package com.example.phoneapp.room

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Phone")
data class PhoneNumber(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "Name")
    val name: String,
    @ColumnInfo(name = "PhoneNumber")
    val phoneNumber: String
) {
    companion object PhoneDiffUtil : DiffUtil.ItemCallback<PhoneNumber>() {
        override fun areItemsTheSame(oldItem: PhoneNumber, newItem: PhoneNumber): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PhoneNumber, newItem: PhoneNumber): Boolean {
            return oldItem == newItem
        }

    }
}