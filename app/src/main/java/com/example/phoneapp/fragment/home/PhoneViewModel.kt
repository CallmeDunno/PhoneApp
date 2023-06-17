package com.example.phoneapp.fragment.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phoneapp.room.PhoneNumber

class PhoneViewModel : ViewModel() {
    private var repository: PhoneRepository? = null
    init {
        repository = PhoneRepository()
    }

    fun getListData(context: Context):MutableLiveData<List<PhoneNumber>>{
        return repository!!.getListData(context)
    }

    fun addToList(phoneNumber: PhoneNumber, context: Context){
        return repository!!.addToList(phoneNumber, context)
    }
}