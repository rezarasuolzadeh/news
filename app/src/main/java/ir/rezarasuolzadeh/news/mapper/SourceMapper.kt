package ir.rezarasuolzadeh.news.mapper

import ir.rezarasuolzadeh.news.utils.interfaces.Mapper
import ir.rezarasuolzadeh.news.model.SourceModel
import ir.rezarasuolzadeh.news.response.SourceResponse
import javax.inject.Inject

class SourceMapper @Inject constructor() : Mapper<SourceResponse, SourceModel> {

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