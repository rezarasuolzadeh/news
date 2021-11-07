package ir.rezarasuolzadeh.news.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import ir.rezarasuolzadeh.news.api.NewsAPI
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.mapper.NewsMapper
import ir.rezarasuolzadeh.news.repository.interfaces.NewsRepository
import javax.inject.Inject

@ActivityRetainedScoped
class NewsRepositoryImp @Inject constructor(
    private val newsAPI: NewsAPI,
    private val mapper: NewsMapper
) : NewsRepository {

    override suspend fun getHeadlineNews(q: String): List<NewsModel> {
        return newsAPI.getHeadlineNews(q = q).articles.map {
            mapper.mapResponseToModel(
                it
            )
        }
    }

    override suspend fun getOtherNews(language: String): List<NewsModel> {
        return newsAPI.getOtherNews(language = language).articles.map {
            mapper.mapResponseToModel(
                it
            )
        }
    }

}