package ir.rezarasuolzadeh.news.repository

import ir.rezarasuolzadeh.news.api.NewsAPI
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.mapper.NewsMapper
import ir.rezarasuolzadeh.news.repository.interfaces.NewsRepository

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