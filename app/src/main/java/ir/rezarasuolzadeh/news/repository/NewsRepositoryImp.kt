package ir.rezarasuolzadeh.news.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import ir.rezarasuolzadeh.news.api.NewsAPI
import ir.rezarasuolzadeh.news.database.dao.SavedNewsDao
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.mapper.NewsMapper
import ir.rezarasuolzadeh.news.mapper.SavedNewsMapper
import ir.rezarasuolzadeh.news.utils.interfaces.NewsRepository
import javax.inject.Inject

@ActivityRetainedScoped
class NewsRepositoryImp @Inject constructor(
    private val newsAPI: NewsAPI,
    private val savedNewsDao: SavedNewsDao,
    private val mapper: NewsMapper,
    private val savedNewsMapper: SavedNewsMapper
) : NewsRepository {

    override suspend fun getHeadlineNews(): List<NewsModel> {
        return newsAPI.getHeadlineNews().articles.map {
            mapper.mapResponseToModel(
                it
            )
        }
    }

    override suspend fun getSavedNews(): List<NewsModel> {
        return savedNewsDao.getAllNews().map {
            savedNewsMapper.mapModelToResponse(
                it
            )
        }
    }

    override suspend fun insertSavedNews(news: NewsModel) {
        savedNewsDao.insertNews(savedNewsMapper.mapResponseToModel(news))
    }

    override suspend fun deleteNews(news: NewsModel) {
        savedNewsDao.deleteNews(savedNewsMapper.mapResponseToModel(news))
    }

    override suspend fun existNews(url: String) : Boolean {
        return savedNewsDao.existNews(url)
    }

}