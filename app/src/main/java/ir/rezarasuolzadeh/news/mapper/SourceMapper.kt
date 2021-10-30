package ir.rezarasuolzadeh.news.mapper

import ir.rezarasuolzadeh.news.mapper.interfaces.Mapper
import ir.rezarasuolzadeh.news.model.SourceModel
import ir.rezarasuolzadeh.news.response.SourceResponse

class SourceMapper : Mapper<SourceResponse, SourceModel> {

    override fun mapResponseToModel(response: SourceResponse): SourceModel {
        return SourceModel(
            name = response.name ?: "",
            url = response.url ?: ""
        )
    }

    override fun mapModelToResponse(model: SourceModel): SourceResponse {
        return SourceResponse(
            name = model.name,
            url = model.url
        )
    }

}