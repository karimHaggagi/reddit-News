package com.karimhaggagi.grandtask.data.data_source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NewDao {

    @Query("SELECT * FROM NewsTable")
    fun getNewsList(): Flow<List<DatabaseNews>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(news: List<DatabaseNews>)

    @Query("DELETE FROM NewsTable")
    fun deletePreviousData()
}