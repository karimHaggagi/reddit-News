package com.karimhaggagi.grandtask.domain.repository

import androidx.lifecycle.LiveData
import com.karimhaggagi.grandtask.data.data_source.local.DatabaseNews
import com.karimhaggagi.grandtask.domain.model.NewsDto
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun refreshNewsList(): NewsDto
    suspend fun insertNewLis(list: List<DatabaseNews>)
    fun getNewsList(): Flow<List<DatabaseNews>>
}