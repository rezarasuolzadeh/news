package ir.rezarasuolzadeh.news.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.rezarasuolzadeh.news.utils.constants.Constants.EXCEPTION_LOG_KEY
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel: ViewModel() {

    private val error = MutableLiveData<Boolean>(null)
    val errorLiveData: LiveData<Boolean>
        get() = error

    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e(EXCEPTION_LOG_KEY, exception.message.toString())
        error.value = true
    }

}