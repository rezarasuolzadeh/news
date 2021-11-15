package ir.rezarasuolzadeh.news.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SourceModel(
    val name: String,
    val url: String
) : Parcelable