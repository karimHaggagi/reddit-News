package com.karimhaggagi.grandtask.data.data_source.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.karimhaggagi.grandtask.domain.model.NewsModel
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "NewsTable")
data class DatabaseNews(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String,
    val thumbnail_url: String,
    val thumbnail_width: Int,
    val thumbnail_height: Int,
    val author_fullname:String,
    val subreddit:String,
    val name:String
) : Parcelable

fun DatabaseNews.asNewsModel(): NewsModel {
    return NewsModel(
        title = title,
        thumbnail_url = thumbnail_url,
        thumbnail_width = thumbnail_width,
        thumbnail_height = thumbnail_height,
        author_fullname = author_fullname,
        subreddit = subreddit,
        name= name
    )
}