package ir.rezarasuolzadeh.news.api

import ir.rezarasuolzadeh.news.response.ParentResponse
import ir.rezarasuolzadeh.news.utils.constants.Constants.API_TOKEN
import ir.rezarasuolzadeh.news.utils.constants.Constants.EN
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    suspend fun getHeadlineNews(
        @Query("token") token: String = API_TOKEN,
        @Query("lang") language: String = EN
    ): ParentResponse

}