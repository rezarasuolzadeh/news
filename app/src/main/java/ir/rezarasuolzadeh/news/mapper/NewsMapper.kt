package ir.rezarasuolzadeh.news.mapper

import ir.rezarasuolzadeh.news.mapper.interfaces.Mapper
import ir.rezarasuolzadeh.news.model.NewsModel
import ir.rezarasuolzadeh.news.response.NewsResponse

class NewsMapper : Mapper<NewsResponse, NewsModel> {

    private val sourceMapper = SourceMapper()

    override fun mapResponseToModel(response: NewsResponse): NewsModel {
        return NewsModel(
            title = response.title ?: "",
            description = response.description ?: "",
            content = response.content ?: "",
            url = response.url ?: "",
            image = response.image ?: "",
            publishedAt = response.publishedAt ?: "",
            sourceModel = response.source?.let { sourceMapper.mapResponseToModel(it) }
        )
    }

    override fun mapModelToResponse(model: NewsModel): NewsResponse {
        return NewsResponse(
            title = model.title,
            description = model.description,
            content = model.content,
            url = model.url,
            image = model.image,
            publishedAt = model.publishedAt,
            source = model.sourceModel?.let { sourceMapper.mapModelToResponse(it) }
        )
    }

}