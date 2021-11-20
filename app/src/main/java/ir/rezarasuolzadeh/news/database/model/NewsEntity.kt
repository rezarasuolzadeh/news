package ir.rezarasuolzadeh.news.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.rezarasuolzadeh.news.utils.constants.Constants.SAVED_NEWS_TABLE

@Entity(tableName = SAVED_NEWS_TABLE)
data class NewsEntity(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "url")
    @PrimaryKey(autoGenerate = false)
    val url: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "published_at")
    val publishedAt: String,
    @ColumnInfo(name = "source_name")
    val sourceName: String,
    @ColumnInfo(name = "source_url")
    val sourceUrl: String
)