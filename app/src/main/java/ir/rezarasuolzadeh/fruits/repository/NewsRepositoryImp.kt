package ir.rezarasuolzadeh.fruits.repository

import ir.rezarasuolzadeh.fruits.api.NewsAPI
import ir.rezarasuolzadeh.fruits.model.NewsModel
import ir.rezarasuolzadeh.fruits.mapper.NewsMapper
import ir.rezarasuolzadeh.fruits.repository.interfaces.NewsRepository

class NewsRepositoryImp(
    private val newsAPI: NewsAPI,
    private val mapper: NewsMapper
) : NewsRepository {

    override suspend fun getHeadlineNews(q: String): List<NewsModel> {
        return newsAPI.getHeadlineNews(q = q).totalArticles.map {
            mapper.mapResponseToModel(
                it
            )
        }
    }

    override suspend fun getOtherNews(language: String): List<NewsModel> {
        return newsAPI.getOtherNews(language = language).totalArticles.map {
            mapper.mapResponseToModel(
                it
            )
        }
    }

}