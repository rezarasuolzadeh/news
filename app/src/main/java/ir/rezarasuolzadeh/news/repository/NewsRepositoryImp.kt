package ir.rezarasuolzadeh.news.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import ir.rezarasuolzadeh.news.api.NewsAPI
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.mapper.NewsMapper
import ir.rezarasuolzadeh.news.utils.interfaces.NewsRepository
import javax.inject.Inject

@ActivityRetainedScoped
class NewsRepositoryImp @Inject constructor(
    private val newsAPI: NewsAPI,
    private val mapper: NewsMapper
) : NewsRepository {

    override suspend fun getHeadlineNews(): List<NewsModel> {
        return newsAPI.getHeadlineNews().articles.map {
            mapper.mapResponseToModel(
                it
            )
        }
    }

    override suspend fun getOtherNews(q: String): List<NewsModel> {
        return newsAPI.getOtherNews(q = q).articles.map {
            mapper.mapResponseToModel(
                it
            )
        }
    }

}