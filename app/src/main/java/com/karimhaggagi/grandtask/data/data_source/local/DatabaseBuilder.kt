package com.karimhaggagi.grandtask.data.data_source.local

import android.app.Application
import androidx.room.Room

object DatabaseBuilder {

    fun provideDataBase(application: Application): NewsDatabase {
        return Room.databaseBuilder(application, NewsDatabase::class.java, "NEWS-DATABASE")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: NewsDatabase): NewDao = dataBase.newDao

}