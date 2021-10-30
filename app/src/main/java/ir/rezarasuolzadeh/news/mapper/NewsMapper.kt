package ir.rezarasuolzadeh.news.mapper

import ir.rezarasuolzadeh.news.mapper.interfaces.Mapper
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.response.NewsResponse

class NewsMapper : Mapper<NewsResponse, NewsModel> {

    private val sourceMapper = SourceMapper()

    override fun mapResponseToModel(model: NewsResponse): NewsModel {
        return NewsModel(
            title = model.title ?: "",
            description = model.description ?: "",
            content = model.content ?: "",
            url = model.url ?: "",
            image = model.image ?: "",
            publishedAt = model.publishedAt ?: "",
            sourceModel = model.source?.let { sourceMapper.mapResponseToModel(it) }
        )
    }

    override fun mapModelToResponse(domainModel: NewsModel): NewsResponse {
        return NewsResponse(
            title = domainModel.title,
            description = domainModel.description,
            content = domainModel.content,
            url = domainModel.url,
            image = domainModel.image,
            publishedAt = domainModel.publishedAt,
            source = domainModel.sourceModel?.let { sourceMapper.mapModelToResponse(it) }
        )
    }

}