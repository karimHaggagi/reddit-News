package com.karimhaggagi.grandtask.data.data_source.remote

import com.karimhaggagi.grandtask.domain.model.NewsDto
import retrofit2.http.GET

interface ApiService {

    @GET(".json")
    suspend fun getNewsList(): NewsDto
}