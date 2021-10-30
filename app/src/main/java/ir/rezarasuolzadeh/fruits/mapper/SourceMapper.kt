package ir.rezarasuolzadeh.fruits.mapper

import ir.rezarasuolzadeh.fruits.mapper.interfaces.Mapper
import ir.rezarasuolzadeh.fruits.model.SourceModel
import ir.rezarasuolzadeh.fruits.response.SourceResponse

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