package ir.rezarasuolzadeh.news.database.dao

import androidx.room.*

import androidx.room.OnConflictStrategy
import ir.rezarasuolzadeh.news.database.model.NewsEntity
import ir.rezarasuolzadeh.news.utils.constants.Constants.SAVED_NEWS_TABLE

@Dao
interface SavedNewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: NewsEntity)

    @Delete
    suspend fun deleteNews(news: NewsEntity)

    @Query("SELECT * FROM $SAVED_NEWS_TABLE")
    suspend fun getAllNews(): List<NewsEntity>

    @Query("SELECT EXISTS (SELECT 1 FROM $SAVED_NEWS_TABLE WHERE url = :url)")
    suspend fun existNews(url: String): Boolean

}