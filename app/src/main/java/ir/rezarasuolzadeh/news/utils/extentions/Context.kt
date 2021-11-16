package ir.rezarasuolzadeh.news.utils.extentions

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String?) {
    Toast.makeText(this, message ?: "null", Toast.LENGTH_SHORT).show()
}