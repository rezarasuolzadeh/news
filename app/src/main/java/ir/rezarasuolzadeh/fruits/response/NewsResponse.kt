package ir.rezarasuolzadeh.fruits.response

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("name")
    val title: String?,
    @SerializedName("url")
    val description: String?,
    @SerializedName("url")
    val content: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("url")
    val image: String?,
    @SerializedName("url")
    val publishedAt: String?,
    @SerializedName("url")
    val source: SourceResponse?
)