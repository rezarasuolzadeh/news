package ir.rezarasuolzadeh.news.api

import ir.rezarasuolzadeh.news.response.ParentResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    suspend fun getHeadlineNews(
        @Query("token") token: String = "a0e14c0511e15abc3e818906ddd127df",
        @Query("lang") language: String = "en"
    ): ParentResponse

    @GET("search")
    suspend fun getOtherNews(
        @Query("token") token: String = "a0e14c0511e15abc3e818906ddd127df",
        @Query("lang") language: String = "en",
        @Query("q") q: String
    ): ParentResponse

}