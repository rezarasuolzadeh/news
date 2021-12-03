package ir.rezarasuolzadeh.news.utils.interfaces

import ir.rezarasuolzadeh.news.model.NewsModel

interface Repository {

    suspend fun getHeadlineNews(): List<NewsModel>

    suspend fun getSavedNews(): List<NewsModel>

    suspend fun insertSavedNews(news: NewsModel)

    suspend fun deleteNews(news: NewsModel)

    suspend fun existNews(url: String): Boolean

}