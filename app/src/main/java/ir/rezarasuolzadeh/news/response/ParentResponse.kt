package ir.rezarasuolzadeh.news.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ParentResponse(
    @Json(name = "articles")
    val articles: List<NewsResponse>,
    @Json(name = "totalArticles")
    val totalArticles: Int
)