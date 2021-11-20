package ir.rezarasuolzadeh.news.mapper

import ir.rezarasuolzadeh.news.database.model.NewsEntity
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.model.SourceModel
import ir.rezarasuolzadeh.news.utils.interfaces.Mapper
import javax.inject.Inject

class SavedNewsMapper @Inject constructor() : Mapper<NewsModel, NewsEntity> {

    override fun mapResponseToModel(response: NewsModel): NewsEntity {
        return NewsEntity(
            title = response.title,
            description = response.description,
            content = response.content,
            url = response.url,
            image = response.image,
            publishedAt = response.publishedAt,
            sourceName = response.sourceModel?.name ?: "",
            sourceUrl = response.sourceModel?.url ?: "",
        )
    }

    override fun mapModelToResponse(model: NewsEntity): NewsModel {
        return NewsModel(
            title = model.title,
            description = model.description,
            content = model.content,
            url = model.url,
            image = model.image,
            publishedAt = model.publishedAt,
            sourceModel = SourceModel(name = model.sourceName, url = model.sourceUrl)
        )
    }

}