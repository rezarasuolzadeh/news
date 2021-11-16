package ir.rezarasuolzadeh.news.utils.interfaces

interface Mapper<Response, Model> {

    fun mapResponseToModel(response: Response): Model

    fun mapModelToResponse(model: Model): Response

}