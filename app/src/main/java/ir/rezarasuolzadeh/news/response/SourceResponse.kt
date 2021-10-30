package ir.rezarasuolzadeh.news.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SourceResponse(
    @Json(name = "name")
    val name: String?,
    @Json(name = "url")
    val url: String?
)