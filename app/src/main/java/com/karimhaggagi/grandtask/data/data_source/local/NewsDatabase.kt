package com.karimhaggagi.grandtask.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DatabaseNews::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract val newDao: NewDao
}