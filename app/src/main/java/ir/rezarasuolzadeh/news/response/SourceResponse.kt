package ir.rezarasuolzadeh.news.response

import com.google.gson.annotations.SerializedName

data class SourceResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)