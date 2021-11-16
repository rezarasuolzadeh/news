package ir.rezarasuolzadeh.news.utils.extentions

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavController

fun NavController.putParcelableBundle(key: String, value: Parcelable) {
    this.currentBackStackEntry?.arguments = Bundle().apply {
        putParcelable(key, value)
    }
}

fun NavController.getParcelableBundle(key: String) : Parcelable? {
    return this.previousBackStackEntry?.arguments?.getParcelable(key)
}