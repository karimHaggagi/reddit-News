package com.karimhaggagi.grandtask.domain.use_case

import com.karimhaggagi.grandtask.data.data_source.local.DatabaseNews
import com.karimhaggagi.grandtask.domain.model.NewsModel
import com.karimhaggagi.grandtask.domain.model.asNewsDatabase
import com.karimhaggagi.grandtask.domain.repository.NewsRepository
import com.karimhaggagi.grandtask.presentation.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun refreshNewsList() = flow {
        emit(UiState.Loading)
        try {
            val response = newsRepository.refreshNewsList()
            val dataList = response.data.children.map { children ->
                NewsModel(
                    title = children.data.title,
                    thumbnail_url = children.data.secure_media?.oembed?.thumbnail_url ?: "",
                    thumbnail_width = children.data.secure_media?.oembed?.thumbnail_width ?: 0,
                    thumbnail_height = children.data.secure_media?.oembed?.thumbnail_height ?: 0,
                    author_fullname = children.data.author_fullname,
                    subreddit = children.data.subreddit,
                    name = children.data.name
                )
            }
            newsRepository.insertNewLis(dataList.map { it.asNewsDatabase() })

            emit(UiState.Success(true))
        } catch (e: Exception) {
            emit(UiState.Error(e.message.toString()))
        }
    }

    fun getNews(): Flow<List<DatabaseNews>> {
        return newsRepository.getNewsList()
    }
}