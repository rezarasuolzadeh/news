package ir.rezarasuolzadeh.news.repository.interfaces

import ir.rezarasuolzadeh.news.model.NewsModel

interface NewsRepository {

    suspend fun getHeadlineNews(): List<NewsModel>

    suspend fun getOtherNews(q: String): List<NewsModel>

}