package ir.rezarasuolzadeh.news.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @Json(name = "name")
    val title: String?,
    @Json(name = "url")
    val description: String?,
    @Json(name = "url")
    val content: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "url")
    val image: String?,
    @Json(name = "url")
    val publishedAt: String?,
    @Json(name = "url")
    val source: SourceResponse?
)