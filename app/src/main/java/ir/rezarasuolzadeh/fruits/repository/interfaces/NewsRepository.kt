package ir.rezarasuolzadeh.fruits.repository.interfaces

import ir.rezarasuolzadeh.fruits.model.NewsModel

interface NewsRepository {

    suspend fun getHeadlineNews(q: String): List<NewsModel>

    suspend fun getOtherNews(language: String): List<NewsModel>

}