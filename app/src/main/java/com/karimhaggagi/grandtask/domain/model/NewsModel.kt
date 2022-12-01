package com.karimhaggagi.grandtask.domain.model

import android.os.Parcelable
import com.karimhaggagi.grandtask.data.data_source.local.DatabaseNews
import com.karimhaggagi.grandtask.data.data_source.local.NewsDatabase
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsModel(
    val title: String,
    val thumbnail_url: String,
    val thumbnail_width: Int,
    val thumbnail_height: Int,
    val author_fullname:String,
    val subreddit:String,
    val name:String

) : Parcelable

fun NewsModel.asNewsDatabase() = DatabaseNews(
    title = title,
    thumbnail_url = thumbnail_url,
    thumbnail_width = thumbnail_width,
    thumbnail_height = thumbnail_height,
    author_fullname = author_fullname,
    subreddit = subreddit,
    name= name
)
