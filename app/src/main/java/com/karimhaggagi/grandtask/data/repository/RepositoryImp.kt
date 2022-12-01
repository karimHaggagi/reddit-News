package com.karimhaggagi.grandtask.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.karimhaggagi.grandtask.data.data_source.local.DatabaseNews
import com.karimhaggagi.grandtask.data.data_source.local.NewDao
import com.karimhaggagi.grandtask.data.data_source.local.NewsDatabase
import com.karimhaggagi.grandtask.data.data_source.remote.ApiService
import com.karimhaggagi.grandtask.domain.model.NewsDto
import com.karimhaggagi.grandtask.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class RepositoryImp(private val apiService: ApiService, private val newsDatabase: NewsDatabase) :
    NewsRepository {

    override suspend fun refreshNewsList(): NewsDto {
        return apiService.getNewsList()
    }

    override suspend fun insertNewLis(list: List<DatabaseNews>) {
        newsDatabase.newDao.deletePreviousData()
        newsDatabase.newDao.insertAll(list)
    }

    override fun getNewsList(): Flow<List<DatabaseNews>> {
        return newsDatabase.newDao.getNewsList()
    }
}