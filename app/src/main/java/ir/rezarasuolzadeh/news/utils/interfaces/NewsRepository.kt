package ir.rezarasuolzadeh.news.utils.interfaces

import ir.rezarasuolzadeh.news.model.NewsModel

interface NewsRepository {

    suspend fun getHeadlineNews(): List<NewsModel>

    suspend fun getOtherNews(q: String): List<NewsModel>

    suspend fun getSavedNews(): List<NewsModel>

    suspend fun insertSavedNews(news: NewsModel)

    suspend fun deleteNews(news: NewsModel)

    suspend fun existNews(url: String): Boolean

}