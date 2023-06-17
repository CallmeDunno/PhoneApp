package com.example.phoneapp.fragment.home

import android.content.Context
import android.os.Handler
import android.os.HandlerThread
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.phoneapp.room.PhoneDatabase
import com.example.phoneapp.room.PhoneNumber

class PhoneRepository {
    private var listData: MutableLiveData<List<PhoneNumber>>? = null

    init {
        this.listData = MutableLiveData<List<PhoneNumber>>()
    }

    fun getListData(context: Context): MutableLiveData<List<PhoneNumber>> {
        getDataFromDatabase(context)
        return listData!!
    }

    private fun getDataFromDatabase(context: Context) {
        val handlerThread = HandlerThread("Room: Get list")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)
        handler.postDelayed({
            val db = Room.databaseBuilder(
                context.applicationContext,
                PhoneDatabase::class.java,
                "Phone"
            ).build()
            listData!!.postValue(db.phoneDAO().getAllData())
            handlerThread.quit()
        }, 3000)
    }

    fun addToList(phoneNumber : PhoneNumber, context: Context){
        val handlerThread = HandlerThread("Room: Add list")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)
        handler.postDelayed({
            val db = Room.databaseBuilder(
                context.applicationContext,
                PhoneDatabase::class.java,
                "Phone"
            ).build()
            db.phoneDAO().insertData(phoneNumber)
            handlerThread.quit()
        }, 3000)
    }
}