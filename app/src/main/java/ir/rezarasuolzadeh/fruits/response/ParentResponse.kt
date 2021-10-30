package ir.rezarasuolzadeh.fruits.response

import com.google.gson.annotations.SerializedName

data class ParentResponse(
    @SerializedName("articles")
    val articles: Int,
    @SerializedName("totalArticles")
    val totalArticles: List<NewsResponse>
)