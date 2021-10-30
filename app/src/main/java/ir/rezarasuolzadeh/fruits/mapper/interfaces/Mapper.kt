package ir.rezarasuolzadeh.fruits.mapper.interfaces

interface Mapper<Response, Model> {

    fun mapResponseToModel(response: Response): Model

    fun mapModelToResponse(model: Model): Response

}