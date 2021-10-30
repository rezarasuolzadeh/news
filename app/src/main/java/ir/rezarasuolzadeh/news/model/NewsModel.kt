package ir.rezarasuolzadeh.news.model

data class NewsModel(
    val title: String,
    val description: String,
    val content: String,
    val url: String,
    val image: String,
    val publishedAt: String,
    val sourceModel: SourceModel?,
)