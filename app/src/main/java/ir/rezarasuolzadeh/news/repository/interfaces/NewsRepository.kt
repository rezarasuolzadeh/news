package ir.rezarasuolzadeh.news.repository.interfaces

import ir.rezarasuolzadeh.news.model.NewsModel

interface NewsRepository {

    suspend fun getHeadlineNews(q: String): List<NewsModel>

    suspend fun getOtherNews(language: String): List<NewsModel>

}